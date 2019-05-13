package com.test.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.test.spring.model.Role;
import com.test.spring.model.User;
import com.test.spring.repo.UserServiceImpl;

@Namespace(value="/app/validation")
public class RegisterAction {

	public RegisterAction() {
		roles = new ArrayList<String>();
		roles.add("admin");roles.add("user");
	}

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Action(value="register", results = {
			@Result(name="success", location="/WEB-INF/content/app/validation/login.jsp"),
			@Result(name="error", location="/WEB-INF/content/app/validation/register.jsp")})
	public String register() throws Exception {
		System.out.println("Register Action !!");

		if(getName()!=null && getUsername()!=null && getPwd()!=null && getSelectedRole()!=null) {
			System.out.println("getSelectedRole() : "+getSelectedRole());
			
			User user = new User(getName(), getUsername(), getPwd());
			user.addRole(new Role(getSelectedRole()));
			
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
	private List<String> roles;
	private String selectedRole;

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
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getSelectedRole() {
		return selectedRole;
	}
	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}

}
