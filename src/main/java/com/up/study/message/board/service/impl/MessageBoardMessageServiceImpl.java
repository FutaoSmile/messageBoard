package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.controller.model.AddMessageReq;
import com.up.study.message.board.controller.model.MessagePageDTO;
import com.up.study.message.board.controller.model.MessageWithCategoryTagDTO;
import com.up.study.message.board.entity.CategoryEntity;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.entity.MessageTagEntity;
import com.up.study.message.board.events.MessageViewEvent;
import com.up.study.message.board.framework.db.entity.base.BaseIdCreateDateTime;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.user.BasicUser;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.mapper.MessageBoardMessageTagMapper;
import com.up.study.message.board.service.MessageBoardCategoryService;
import com.up.study.message.board.service.MessageBoardMessageService;
import com.up.study.message.board.mapper.MessageBoardMessageMapper;
import com.up.study.message.board.service.MessageBoardMessageTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【message_board_message(留言表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardMessageServiceImpl extends ServiceImpl<MessageBoardMessageMapper, MessageEntity>
        implements MessageBoardMessageService {

    @Resource
    private MessageBoardMessageTagMapper messageBoardMessageTagMapper;
    @Resource
    private MessageBoardMessageTagService messageBoardMessageTagService;
    @Resource
    private MessageBoardCategoryService messageBoardCategoryService;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addMessage(AddMessageReq addMessageReq) {
        MessageEntity entity = new MessageEntity();
        BeanUtils.copyProperties(addMessageReq, entity);
        entity.setUserId(CurrentUser.getUser().getId());
        this.save(entity);

        Long messageId = entity.getId();
        List<Long> tagIdList = addMessageReq.getTagIdList();
        if (!CollectionUtils.isEmpty(tagIdList)) {
            for (Long tagId : tagIdList) {
                MessageTagEntity messageTagEntity = new MessageTagEntity();
                messageTagEntity.setMessageId(messageId);
                messageTagEntity.setTagId(tagId);
                messageBoardMessageTagMapper.insert(messageTagEntity);
            }
        }
    }

    @Override
    public MessageWithCategoryTagDTO detail(Long id) {
        MessageEntity messageEntity = this.getById(id);
        Asserts.notNull(messageEntity, "留言不存在");
        MessageWithCategoryTagDTO messageWithCategoryTagDTO = new MessageWithCategoryTagDTO();
        BeanUtils.copyProperties(messageEntity, messageWithCategoryTagDTO);
        messageWithCategoryTagDTO.setTagEntityList(messageBoardMessageTagService.queryByMessageId(id));
        Long categoryId = messageWithCategoryTagDTO.getCategoryId();
        if (categoryId != null) {
            messageWithCategoryTagDTO.setCategoryEntity(messageBoardCategoryService.getById(categoryId));
        }
        applicationEventPublisher.publishEvent(new MessageViewEvent(id));
        messageWithCategoryTagDTO.setViewCount(messageWithCategoryTagDTO.getViewCount() + 1);
        return messageWithCategoryTagDTO;
    }

    @Override
    public Page<MessageWithCategoryTagDTO> page(MessagePageDTO messagePageDTO, Long userId) {
        String keyword = messagePageDTO.getKeyword();
        Long categoryId = messagePageDTO.getCategoryId();
        Page<MessageEntity> page = page(new Page<>(messagePageDTO.getPageNo(), messagePageDTO.getPageSize()), Wrappers.<MessageEntity>lambdaQuery()
                .eq(categoryId != null, MessageEntity::getCategoryId, categoryId)
                .eq(userId != null, MessageEntity::getUserId, userId)
                .and(StringUtils.isNotBlank(keyword), x -> x.like(MessageEntity::getTitle, keyword)
                        .or()
                        .like(MessageEntity::getContent, keyword))
                .orderByDesc(MessageEntity::getId)
        );
        Page<MessageWithCategoryTagDTO> retPage = new Page<>();
        BeanUtils.copyProperties(page, retPage, "records");
        List<MessageEntity> records = page.getRecords();
        List<MessageWithCategoryTagDTO> retList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(records)) {
            Map<Long, CategoryEntity> categoryMap = messageBoardCategoryService.list(Wrappers.<CategoryEntity>lambdaQuery().orderByAsc(CategoryEntity::getId))
                    .stream()
                    .collect(Collectors.toMap(CategoryEntity::getId, Function.identity(), (x1, x2) -> x1));
            retList = records.stream()
                    .map(x -> {
                        MessageWithCategoryTagDTO target = new MessageWithCategoryTagDTO();
                        BeanUtils.copyProperties(x, target, "category", "tagList");
                        target.setCategoryEntity(categoryMap.get(x.getCategoryId()));
                        target.setTagEntityList(messageBoardMessageTagService.queryByMessageId(x.getId()));
                        return target;
                    }).collect(Collectors.toList());
        }
        retPage.setRecords(retList);
        return retPage;
    }
}




