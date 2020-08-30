package com.practice.vvr.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;
public class CustomEmailValidator implements ConstraintValidator<ValidEmail, String>{
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return false;
		}
		return EmailValidator.getInstance().isValid(value);
	}

}
