package com.up.study.message.board.config;

import com.up.study.message.board.framework.login.interceptor.LoginAuthInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Component
public class WebMvc implements WebMvcConfigurer {
    @Resource
    private LoginAuthInterceptor loginAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 权限拦截器
        registry.addInterceptor(loginAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/uploadFile")
                .excludePathPatterns("/doc/**")
                .excludePathPatterns("/login/**")
        ;
    }
}
