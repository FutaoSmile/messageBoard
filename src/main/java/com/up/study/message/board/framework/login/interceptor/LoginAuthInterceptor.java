package com.up.study.message.board.framework.login.interceptor;


import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.exception.LogicException;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.login.constant.LoginConstant;
import com.up.study.message.board.framework.restful.constants.ErrorMessages;
import com.up.study.message.board.framework.user.BasicUser;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.framework.util.enums.EnumUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 * 用户登录状态拦截器
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@Component
public class LoginAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("request path:{}", request.getRequestURI());
        CurrentUser.clear();
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LoginRequire loginRequire = AnnotationUtils.getAnnotation(handlerMethod.getMethod(), LoginRequire.class);
            if (loginRequire != null) {
                Object sessionUser = Optional.ofNullable(request.getSession(false))
                        .map(session -> session.getAttribute(LoginConstant.SESSION_ATTR))
                        .orElseThrow(() -> LogicException.le(ErrorMessages.NOT_LOGIN));
                Asserts.notNull(sessionUser, ErrorMessages.NOT_LOGIN);
                BasicUser currentUser = (BasicUser) sessionUser;
                UserRoleEnum[] requireRoles = loginRequire.requireRoles();
                UserRoleEnum userRoleEnum = EnumUtils.byValueOptional(UserRoleEnum.class, currentUser.getRole()).orElseThrow(() -> LogicException.le("请联系管理员给您设置角色"));
                Asserts.truth(Arrays.asList(requireRoles).contains(userRoleEnum), ErrorMessages.NOT_PERMIT);
                CurrentUser.set(currentUser);
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 通过DispatcherServlet源码可以知道，如果发生了异常，是不会执行这个方法的
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentUser.clear();
        log.debug("清除线程缓存");
    }
}