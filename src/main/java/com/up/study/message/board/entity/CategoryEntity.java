package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 标签表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_category")
public class CategoryEntity extends BaseIdUserTime {
    /**
     * 标签名
     */
    public String categoryName;
}
