package com.up.study.message.board.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@Validated
public class UserRegisterBody {
    /**
     * 手机号
     */
    @NotBlank
    private String phone;
    /**
     * 密码
     */
    @NotBlank
    private String password;
}
