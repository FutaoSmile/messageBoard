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
import com.up.study.message.board.service.MessageBoardTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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
        Page<MessageEntity> page = messageBoardMessageService.page(new Page<>(messagePageDTO.getPageNo(), messagePageDTO.getPageSize()), Wrappers.<MessageEntity>lambdaQuery()
                .eq(MessageEntity::getCategoryId, messagePageDTO.getCategoryId())
                .orderByDesc(MessageEntity::getId)
        );
        Page<MessageWithCategoryTagDTO> retPage = new Page<>();
        BeanUtils.copyProperties(page, retPage, "records");
        List<MessageWithCategoryTagDTO> retList = page.getRecords().stream()
                .map(x -> {
                    MessageWithCategoryTagDTO target = new MessageWithCategoryTagDTO();
                    BeanUtils.copyProperties(x, target, "category", "tagList");

                    return target;
                }).collect(Collectors.toList());
        retPage.setRecords(retList);
        return retPage;
    }

}
