package com.up.study.message.board.framework.exception.validate;

import com.up.study.message.board.framework.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
public class AssertEnumValidator implements ConstraintValidator<AssertEnum, Object> {

    private final Set<Object> valueSet = new HashSet<>();

    @Override
    public void initialize(AssertEnum constraintAnnotation) {
        Class<? extends Enum> enumType = constraintAnnotation.enumClazz();
        String getValueMethodName = constraintAnnotation.getValueMethodName();
        try {
            Method valueMethod = enumType.getMethod(getValueMethodName);
            for (Enum<?> enumConstant : enumType.getEnumConstants()) {
                valueSet.add(valueMethod.invoke(enumConstant));
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw ApplicationException.ae("枚举[" + enumType.getName() + "]没有方法[" + getValueMethodName + "]", e);
        }

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return valueSet.contains(value);
    }
}
