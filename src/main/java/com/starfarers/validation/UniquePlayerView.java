package com.starfarers.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.starfarers.validation.validator.UniquePlayerViewValidator;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePlayerViewValidator.class)
@Documented
public @interface UniquePlayerView {

	String message() default "Unique";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}