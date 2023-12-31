package com.be.annotation;

import com.be.handler.Utils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CheckEmail.ValidatorValue.class)
public @interface CheckEmail {

    int value() default 0;

    String message() default "invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@link CheckEmail} annotations on the same element
     */
    @Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CheckEmail[] value();
    }

    class ValidatorValue implements ConstraintValidator<CheckEmail, String> {

        @Override
        public void initialize(CheckEmail constraintAnnotation) {
        }

        @Override
        public boolean isValid(String content, ConstraintValidatorContext constraintValidatorContext) {
            if (content == null) {
                return false;
            }
            return Utils.isEmail(content);
        }
    }

}
