package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.test.spring.model.User;
import com.test.struts2.domain.user.LoginDomain;

@Namespaces(value= { @Namespace("/User"), @Namespace("/")})
/*@Action(value="login", results = {
		@Result(name="error", location="/welcome.jsp"),
		@Result(name="success", location="/error.jsp")})

@Action at class level has higher preference than at method level		*/
public class LoginAction {

	private LoginDomain loginDomain;

	public void setLoginDomain(LoginDomain loginDomain) {
		this.loginDomain = loginDomain;
	}
	@Action(value="login", results = {
			@Result(name="success", location="/welcome.jsp"),
			@Result(name="error", location="/error.jsp")})

	public String execute() throws Exception {
		User userdb = loginDomain.validateLogin(new User(getName(), getUsername(), getPwd()));
		if(userdb !=null) {
			name = userdb.getName();
			System.out.println(name+" is logged in !!");
			return ActionSupport.SUCCESS;
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