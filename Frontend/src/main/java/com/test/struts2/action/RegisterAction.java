package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/User")
public class RegisterAction {

	@Action(value="register", results = {
			@Result(name="success", location="/login.jsp"),
			@Result(name="error", location="/register.jsp")})
	public String execute() throws Exception {

		/*
		 * Here we need to call db services to register user
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
