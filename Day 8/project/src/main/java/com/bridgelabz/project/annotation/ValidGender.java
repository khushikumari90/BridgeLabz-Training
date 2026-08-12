package com.bridgelabz.project.annotation;

import com.bridgelabz.project.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGender {
    String message() default "Gender must be male or female";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
