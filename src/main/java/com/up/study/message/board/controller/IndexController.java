package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.MessagePageDTO;
import com.up.study.message.board.controller.model.MessageWithCategoryTagDTO;
import com.up.study.message.board.entity.CategoryEntity;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.entity.TagEntity;
import com.up.study.message.board.service.MessageBoardCategoryService;
import com.up.study.message.board.service.MessageBoardMessageService;
import com.up.study.message.board.service.MessageBoardMessageTagService;
import com.up.study.message.board.service.MessageBoardTagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 前台接口
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/index")
@Validated
public class IndexController {

    @Resource
    private MessageBoardCategoryService messageBoardCategoryService;
    @Resource
    private MessageBoardTagService messageBoardTagService;
    @Resource
    private MessageBoardMessageService messageBoardMessageService;
    @Resource
    private MessageBoardMessageTagService messageBoardMessageTagService;

    /**
     * 分类列表
     *
     * @return
     */
    @GetMapping("/category-list")
    public List<CategoryEntity> categoryList() {
        return messageBoardCategoryService.list(Wrappers.<CategoryEntity>lambdaQuery().orderByAsc(CategoryEntity::getId));
    }

    /**
     * 标签列表
     *
     * @return
     */
    @GetMapping("/tag-list")
    public List<TagEntity> tagList() {
        return messageBoardTagService.list(Wrappers.<TagEntity>lambdaQuery().orderByAsc(TagEntity::getId));
    }

    /**
     * 留言列表
     *
     * @return
     */
    @GetMapping("/message-page")
    public Page<MessageWithCategoryTagDTO> messagePage(@Validated MessagePageDTO messagePageDTO) {
        String keyword = messagePageDTO.getKeyword();
        Page<MessageEntity> page = messageBoardMessageService.page(new Page<>(messagePageDTO.getPageNo(), messagePageDTO.getPageSize()), Wrappers.<MessageEntity>lambdaQuery()
                .eq(MessageEntity::getCategoryId, messagePageDTO.getCategoryId())
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
            Map<Long, CategoryEntity> categoryMap = this.categoryList().stream()
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
