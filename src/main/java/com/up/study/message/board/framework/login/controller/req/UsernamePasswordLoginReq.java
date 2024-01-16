package com.up.study.message.board.framework.login.controller.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class UsernamePasswordLoginReq {
    /**
     * 用户名
     */
    @NotBlank
    private String phone;

    /**
     * 密码
     */
    @NotBlank(message = "请输入密码")
    private String password;
}
