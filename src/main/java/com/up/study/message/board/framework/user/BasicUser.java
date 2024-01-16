package com.up.study.message.board.framework.user;

import com.alibaba.fastjson2.JSON;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户基类
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class BasicUser extends BaseIdUserTime {
    /**
     * 用户名
     */
    private String username;

    /**
     * 角色
     *
     * @see com.up.study.message.board.framework.user.enums.UserRoleEnum
     */
    private Integer role;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
