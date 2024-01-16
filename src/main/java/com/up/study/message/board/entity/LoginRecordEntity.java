package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录记录表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_login_record")
public class LoginRecordEntity extends BaseIdUserTime {
    /**
     * 关联的用户id
     */
    private Long userId;
    /**
     * 登录的用户ip
     */
    private String ip;
    /**
     * 登录的用户浏览器
     */
    private String userAgent;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
}
