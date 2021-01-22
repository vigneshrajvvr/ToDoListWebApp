package com.practice.vvr.todolistapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.vvr.todolistapp.entity.TempUser;

public class PasswordsEqualConstraintValidator implements
	ConstraintValidator<PasswordsEqualConstraint, Object>{
	
	@Autowired
    private TempUser tempUser;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return tempUser.getPassword().equals(tempUser.getConfirmPassword());
	}

}
