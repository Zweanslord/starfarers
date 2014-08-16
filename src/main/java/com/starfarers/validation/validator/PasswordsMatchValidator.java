package com.starfarers.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.starfarers.validation.PasswordsMatch;
import com.starfarers.view.NewPassword;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, NewPassword> {

	public void initialize(PasswordsMatch constraintAnnotation) {
	}

	public boolean isValid(NewPassword newPassword, ConstraintValidatorContext context) {
		return newPassword.getPassword().equals(newPassword.getPasswordConfirmation());
	}

}