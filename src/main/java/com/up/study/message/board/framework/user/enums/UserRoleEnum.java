package com.up.study.message.board.framework.user.enums;

import com.up.study.message.board.framework.util.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnum implements IEnum<Integer> {
    /**
     * 0=管理员
     */
    ADMIN(0, "超管"),
    /**
     * 1=普通用户
     */
    NORMAL_USER(1, "普通用户");

    private final int role;
    private final String desc;

    @Override
    public Integer logicValue() {
        return role;
    }
}
