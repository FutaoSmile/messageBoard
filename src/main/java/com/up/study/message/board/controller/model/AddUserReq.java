package com.up.study.message.board.controller.model;

import com.up.study.message.board.entity.enums.GenderEnum;
import com.up.study.message.board.entity.enums.UserStatusEnum;
import com.up.study.message.board.framework.exception.validate.AssertEnum;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class AddUserReq {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;
    /**
     * 头像
     */
    @NotBlank(message = "头像不能为空")
    private String avatar;
    /**
     * 用户状态
     *
     * @see com.up.study.message.board.entity.enums.UserStatusEnum
     */
    @NotNull(message = "用户状态不能为空")
    @AssertEnum(enumClazz = UserStatusEnum.class)
    private Integer status;
    /**
     * 角色
     *
     * @see com.up.study.message.board.framework.user.enums.UserRoleEnum
     */
    @NotNull(message = "角色不能为空")
    @AssertEnum(enumClazz = UserRoleEnum.class)
    private Integer role;
    /**
     * 性别
     *
     * @see com.up.study.message.board.entity.enums.GenderEnum
     */
    @NotNull(message = "性别不能为空")
    @AssertEnum(enumClazz = GenderEnum.class)
    private Integer gender;
    /**
     * 生日
     */
    @NotNull(message = "生日不能为空")
    private Long birthday;
}
