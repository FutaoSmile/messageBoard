package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.controller.model.AddMessageReq;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.entity.MessageTagEntity;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.mapper.MessageBoardMessageTagMapper;
import com.up.study.message.board.service.MessageBoardMessageService;
import com.up.study.message.board.mapper.MessageBoardMessageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
}




