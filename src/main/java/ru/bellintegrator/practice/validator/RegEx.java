package ru.bellintegrator.practice.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegExConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegEx {
    String value();

    String message() default "{RegEx}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
