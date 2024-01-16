package com.up.study.message.board.framework.util;

import lombok.experimental.UtilityClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * 枚举工具类
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@UtilityClass
public class AnnotationUtils {

    /**
     * 获取方法上的注解，如果方法上没有，则获取类上的注解
     *
     * @param method          方法
     * @param annotationClass 注解类
     * @param <T>             注解类型
     * @return 注解
     */
    public <T extends Annotation> T getAnnotation(Method method, Class<T> annotationClass) {
        return Optional.ofNullable(method.getAnnotation(annotationClass))
                .orElse(method.getDeclaringClass().getAnnotation(annotationClass));
    }

}
