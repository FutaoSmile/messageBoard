package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.user.BasicUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_user")
@Builder
public class UserEntity extends BasicUser {
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 上次登录时间
     */
    private Long lastLoginTime;
    /**
     * 用户状态
     *
     * @see com.up.study.message.board.entity.enums.UserStatusEnum
     */
    private Integer status;
    /**
     * 性别
     *
     * @see com.up.study.message.board.entity.enums.GenderEnum
     */
    private String gender;
    /**
     * 生日
     */
    private Long birthday;
    /**
     * 注册日期
     */
    private Long registerDateTime;
}
