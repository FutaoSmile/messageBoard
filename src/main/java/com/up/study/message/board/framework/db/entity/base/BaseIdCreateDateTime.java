package com.up.study.message.board.framework.db.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 包含id、创建时间
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@ToString
public abstract class BaseIdCreateDateTime implements Serializable {
    private static final long serialVersionUID = 4705716610411859345L;

    /**
     * 数据主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    public static final String ID_FIELD = "id";
    public static final String ID_COLUMN = "id";

    /**
     * 创建时间戳
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createDateTime;
    public static final String CREATE_DATE_TIME_FIELD = "createDateTime";
    public static final String CREATE_DATE_TIME_COLUMN = "create_date_time";

}