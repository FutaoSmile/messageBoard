package com.up.study.message.board.controller.model;

import com.up.study.message.board.entity.CategoryEntity;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.entity.TagEntity;

import java.util.List;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
public class MessageWithCategoryTagDTO extends MessageEntity {
    /**
     * 关联的分类
     */
    private CategoryEntity categoryEntity;
    /**
     * 关联的标签列表
     */
    private List<TagEntity> tagEntityList;
}
