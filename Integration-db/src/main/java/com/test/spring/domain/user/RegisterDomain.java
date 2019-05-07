package com.test.spring.domain.user;

import com.test.spring.model.User;

public class RegisterDomain {

	private ValidatorDomain validatorDomain;

	/* 2. Setter based DI */
	public void setValidatorDomain(ValidatorDomain validatorDomain) {
		this.validatorDomain = validatorDomain;
	}

	public boolean validateRegistration(User user) {

		if(validatorDomain.userNameValid(user, UserAction.REGISTRATION) && validatorDomain.passwordValid(user,UserAction.REGISTRATION)) {
			return true;
		}
		return false;
	}
}