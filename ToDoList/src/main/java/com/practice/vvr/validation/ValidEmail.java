package com.practice.vvr.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = CustomEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ValidEmail {
	
	String message() default "Invalid Email";
	
	Class<?>[] groups() default {};
	
    Class<? extends Payload>[] payload() default {};
	
}
