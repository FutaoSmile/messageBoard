package com.up.study.message.board.framework.exception.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Documented
@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AssertEnumValidator.class})
public @interface AssertEnum {
    Class<? extends Enum> enumClazz();

    String getValueMethodName() default "logicValue";

    String message() default "超出取值范围";

    // 以下两行为固定模板
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
