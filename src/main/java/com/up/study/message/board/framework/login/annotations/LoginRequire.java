package com.up.study.message.board.framework.login.annotations;


import com.up.study.message.board.framework.user.enums.UserRoleEnum;

import java.lang.annotation.*;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface LoginRequire {
    /**
     * 要求的角色，默认是普通用户
     *
     * @return 角色集合
     */
    UserRoleEnum[] requireRoles() default {UserRoleEnum.NORMAL_USER};

}
