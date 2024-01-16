package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.BasePageDTO;
import com.up.study.message.board.entity.TagEntity;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.service.MessageBoardTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 标签管理
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/tag")
@Validated
public class TagController {

    @Resource
    private MessageBoardTagService messageBoardTagService;

    /**
     * 新增分类
     *
     * @param tagName
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN})
    @PostMapping
    public void addTag(@RequestParam String tagName) {
        long count = messageBoardTagService.count(Wrappers.<TagEntity>lambdaQuery()
                .eq(TagEntity::getTagName, tagName)
        );
        Asserts.equals(count, 0L, "已存在同名的标签");
        TagEntity entity = new TagEntity();
        entity.setTagName(tagName);
        messageBoardTagService.save(entity);
    }

    /**
     * 分页查询标签
     *
     * @param basePageDTO
     * @return
     */
    @GetMapping("/page")
    public Page<TagEntity> page(BasePageDTO basePageDTO) {
        return messageBoardTagService.page(new Page<>(basePageDTO.getPageNo(), basePageDTO.getPageSize()), Wrappers.<TagEntity>lambdaQuery()
                .orderByAsc(TagEntity::getId)
        );
    }
}
