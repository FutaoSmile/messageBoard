package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.BasePageDTO;
import com.up.study.message.board.entity.CategoryEntity;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.service.MessageBoardCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类管理
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {

    @Resource
    private MessageBoardCategoryService messageBoardCategoryService;

    /**
     * 新增分类
     *
     * @param categoryName
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN})
    @PostMapping
    public void addCategory(@RequestParam String categoryName) {
        long count = messageBoardCategoryService.count(Wrappers.<CategoryEntity>lambdaQuery()
                .eq(CategoryEntity::getCategoryName, categoryName)
        );
        Asserts.equals(count, 0L, "已存在同名的分类");
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryName(categoryName);
        messageBoardCategoryService.save(entity);
    }

    /**
     * 分页查询分类
     *
     * @param basePageDTO
     * @return
     */
    @GetMapping("/page")
    public Page<CategoryEntity> page(BasePageDTO basePageDTO) {
        return messageBoardCategoryService.page(new Page<>(basePageDTO.getPageNo(), basePageDTO.getPageSize()), Wrappers.<CategoryEntity>lambdaQuery()
                .orderByAsc(CategoryEntity::getId)
        );
    }

    /**
     * 分类列表
     *
     * @return
     */
    @GetMapping("/category-list")
    public List<CategoryEntity> categoryList() {
        return messageBoardCategoryService.list(Wrappers.<CategoryEntity>lambdaQuery().orderByAsc(CategoryEntity::getId));
    }
}
