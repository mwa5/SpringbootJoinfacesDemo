package com.persteenolsen.springbootjsfprimefacesjpa.model;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


// This Java Class is a costum validation of an Email using 
// EmailValidator of Apache Commons Validator ( look in the POM )
public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

	private int min;
	private int max;

	@Override
	public void initialize(ValidEmail validEmail) {
		min = validEmail.min();
		max = validEmail.max();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if (email.length() < min) {
			return false;
		}
		if (email.length() > max) {
			return false;
		}

		return true;
	}

}
