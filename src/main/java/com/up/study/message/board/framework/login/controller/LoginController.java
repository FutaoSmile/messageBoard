package com.up.study.message.board.framework.login.controller;

import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.login.constant.LoginConstant;
import com.up.study.message.board.framework.login.controller.req.UsernamePasswordLoginReq;
import com.up.study.message.board.framework.login.peoperties.BasicLoginProperties;
import com.up.study.message.board.framework.login.service.LoginService;
import com.up.study.message.board.framework.user.BasicUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录接口
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @Resource
    private BasicLoginProperties basicLoginProperties;

    /**
     * 用户名密码登录
     *
     * @param usernamePasswordLoginReq
     * @param request
     */
    @PostMapping("/username-pwd")
    public void login(@RequestBody @Validated UsernamePasswordLoginReq usernamePasswordLoginReq, HttpServletRequest request) {
        BasicUser basicUser = loginService.loginByPhonePassword(usernamePasswordLoginReq.getPhone(), usernamePasswordLoginReq.getPassword());
        Asserts.notNull(basicUser, "手机号或密码错误");
        // 获取session会话
        HttpSession session = request.getSession(true);
        // 将用户信息保存到session会话中
        session.setAttribute(LoginConstant.SESSION_ATTR, basicUser);
        // 设置session会话过期时间，秒
        session.setMaxInactiveInterval(Math.toIntExact(basicLoginProperties.getLoginSessionDuration().getSeconds()));
    }

}
