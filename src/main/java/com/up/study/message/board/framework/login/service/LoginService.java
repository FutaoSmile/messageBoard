package com.up.study.message.board.framework.login.service;


import com.up.study.message.board.framework.user.BasicUser;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
public interface LoginService {

    /**
     * 通过用户名密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    BasicUser loginByUsernamePassword(String username, String password);

    BasicUser loginByPhonePassword(String username, String password);
}
