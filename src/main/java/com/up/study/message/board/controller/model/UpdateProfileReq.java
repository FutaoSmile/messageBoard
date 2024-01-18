package com.up.study.message.board.controller.model;

import com.up.study.message.board.framework.exception.validate.AssertEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class UpdateProfileReq {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空")
    private String email;
    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String avatar;
    /**
     * 性别
     *
     * @see com.up.study.message.board.entity.enums.GenderEnum
     */
    @AssertEnum(message = "性别不合法", enumClazz = com.up.study.message.board.entity.enums.GenderEnum.class)
    @NotNull(message = "性别不能为空")
    private Integer gender;
    /**
     * 生日
     */
    @NotNull(message = "生日不能为空")
    private Long birthday;
}
