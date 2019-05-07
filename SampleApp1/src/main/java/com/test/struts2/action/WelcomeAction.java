package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/")
@Action(value="welcome", results = {
		@Result(name="success", location="/welcome.jsp")})
public class WelcomeAction {

	public String execute() throws Exception {

		return ActionSupport.SUCCESS;
	}
}
