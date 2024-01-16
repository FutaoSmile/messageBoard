package com.up.study.message.board.framework.util.enums;

/**
 * 枚举类都需要实现的接口
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
public interface IEnum<R> {
    /**
     * 业务值字段
     *
     * @return
     */
    R logicValue();
}
