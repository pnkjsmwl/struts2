package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespaces(value= { @Namespace("/User"), @Namespace("/")})
/* @Action at class level has higher preference than at method level */
public class LoginAction {

	
	@Action(value="login", results = {
			@Result(name="success", location="/welcome.jsp"),
			@Result(name="error", location="/error.jsp")})

	public String execute() throws Exception {
		
		/*
		 * Here we need to call the db service to validate the user
		 * */
		
		return ActionSupport.SUCCESS;
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