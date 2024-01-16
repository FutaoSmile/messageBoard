package com.up.study.message.board.entity.enums;

import com.up.study.message.board.framework.util.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态枚举
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum implements IEnum<Integer> {

    /**
     * 0=正常
     */
    NORMAL(0, "正常"),
    /**
     * -1=禁用
     */
    DISABLE(-1, "禁用");

    private final int status;
    private final String description;

    @Override
    public Integer logicValue() {
        return status;
    }
}
