package com.test.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.test.spring.model.User;
import com.test.struts2.domain.user.LoginDomain;

@Namespace("/app/validation")
/*@Action at class level has higher preference than action at method level		*/
public class LoginAction {

	private LoginDomain loginDomain;
	private List<String> colors;

	public LoginAction() {
		colors = new ArrayList<String>();
		colors.add("Black");colors.add("White");
	}
	public void setLoginDomain(LoginDomain loginDomain) {
		this.loginDomain = loginDomain;
	}

	@Action(value="login", results = {
			@Result(name="success", location="/WEB-INF/content/app/user/home.jsp"),
			@Result(name="error", location="/WEB-INF/content/app/error/error.jsp")})
	public String login() throws Exception {
		System.out.println("Login Action !!");
		User userdb = loginDomain.validateLogin(new User(null, getUsername(), getPwd()));
		if(userdb !=null) {
			System.out.println(userdb.getName()+" is logged in !!");
			return ActionSupport.SUCCESS;
		}
		return ActionSupport.ERROR;
	}
	private String username;
	private String pwd;

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
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
}