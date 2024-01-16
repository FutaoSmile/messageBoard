package com.up.study.message.board.framework.user.constant;

import lombok.experimental.UtilityClass;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@UtilityClass
public class UserConstants {
    /**
     * 当前登录用户信息在dubbo上下文附件中的key
     */
    public static final String DUBBO_ATTACHMENT_USER = "currentThreadUser";
}
