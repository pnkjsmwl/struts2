package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.test.spring.model.User;
import com.test.spring.repo.UserServiceImpl;

@Namespace(value="/User")
public class RegisterAction {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Action(value="register", results = {
			@Result(name="success", location="/login.jsp"),
			@Result(name="error", location="/register.jsp")})
	public String execute() throws Exception {

		if(getName()!=null && getUsername()!=null && getPwd()!=null) {
			User user = new User(getName(), getUsername(), getPwd());

			if(userServiceImpl.findByUsername(user.getUsername())==null) {
				User added = userServiceImpl.add(user);
				if(added!=null && added.getId()>0)
					return ActionSupport.SUCCESS;
			}
			else
				return ActionSupport.ERROR;
		}
		return ActionSupport.ERROR;
	}

	private String name;
	private String username;
	private String pwd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



}
