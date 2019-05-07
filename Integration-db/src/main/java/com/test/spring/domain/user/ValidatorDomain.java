package com.test.spring.domain.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.model.User;
import com.test.spring.repo.UserServiceImpl;

/**
 * Perform common login/register business logic here
 */
public class ValidatorDomain {

	@Autowired
	private UserServiceImpl userServiceImpl;

	public boolean userNameValid(User user, UserAction action) {
		User userdb = userServiceImpl.findByUsername(user.getUsername());
		if(userdb==null) {
			if(action.equals(UserAction.LOGIN))
				return false;
			else if(action.equals(UserAction.REGISTRATION))
				return true;
		}
		user.setName(userdb.getName());
		return true;
	}

	public boolean passwordValid(User user, UserAction action) {

		if(action.equals(UserAction.REGISTRATION)) {
			if(StringUtils.isWhitespace(user.getPassword()) || StringUtils.isEmpty(user.getPassword()) || user.getPassword().length()<1 || user.getPassword().length()>10)
				return false;
		}else if(action.equals(UserAction.LOGIN)) {
			User userdb = userServiceImpl.findByUsername(user.getUsername());
			System.out.println("User ID/password for:"+user.getUsername()+":"+userdb.getId()+"/"+userdb.getPassword());
			return (userdb.getPassword().equals(user.getPassword()) ? true : false);
		}
		return true;
	}
}
