package com.test.spring.domain.user;

import com.test.spring.model.User;

public class LoginDomain {

	private ValidatorDomain validatorDomain;

	/* 1. Constructor based DI */
	public LoginDomain(ValidatorDomain validatorDomain) {
		this.validatorDomain = validatorDomain;
	}

	public boolean validateLogin(User user) {
		
		if(validatorDomain.userNameValid(user, UserAction.LOGIN) && validatorDomain.passwordValid(user,UserAction.LOGIN)) {
			return true;
		}
		return false;
	}
}
