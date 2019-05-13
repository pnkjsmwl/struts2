package com.test.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.model.User;
import com.test.spring.repo.UserServiceImpl;

@Namespace(value="/app")
public class UtilityAction {

	@Autowired
	private UserServiceImpl userService;

	private List<User> users = new ArrayList<User>();
	
	@Action(value="all", results= {
			@Result(name="success", location="/welcome.jsp"),
			@Result(name="error", location="/welcome.jsp")
	})
	public List<User> getCurrentUsers() {
		users =  userService.showAll();
		return users;
	}
}
