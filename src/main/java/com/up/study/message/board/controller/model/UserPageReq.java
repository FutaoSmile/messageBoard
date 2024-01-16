package com.up.study.message.board.controller.model;

import com.up.study.message.board.entity.enums.GenderEnum;
import com.up.study.message.board.framework.exception.validate.AssertEnum;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class UserPageReq extends BasePageDTO {
    /**
     * 性别
     */
    @AssertEnum(enumClazz = GenderEnum.class)
    private Integer gender;
    /**
     * 角色
     */
    @AssertEnum(enumClazz = UserRoleEnum.class)
    private Integer role;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 注册开始时间
     */
    private Long registerStartDateTime;
    /**
     * 注册结束时间
     */
    private Long registerEndDateTime;
}
