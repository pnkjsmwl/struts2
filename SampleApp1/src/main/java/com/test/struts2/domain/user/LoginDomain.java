package com.test.struts2.domain.user;

import com.test.spring.model.User;

public class LoginDomain {

	private ValidatorDomain validatorDomain;

	/* 1. Constructor based DI */
	public LoginDomain(ValidatorDomain validatorDomain) {
		this.validatorDomain = validatorDomain;
	}

	public User validateLogin(User user) {

		
		if(validatorDomain.userNameValid(user, UserAction.LOGIN) && validatorDomain.passwordValid(user,UserAction.LOGIN)) {
			return user;
		}
		return null;
	}
}
