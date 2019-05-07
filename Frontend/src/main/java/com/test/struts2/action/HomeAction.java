package com.test.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespaces(value= {@Namespace("/User"), @Namespace("/")})
@Actions(value= {@Action("home"), @Action("")})
@Result(location="/login.jsp") // This is default result, custom results are kept inside @Actions 
public class HomeAction extends ActionSupport{ // extend ActionSupport else we don't get redirected to /login.jsp

	private static final long serialVersionUID = 1L;
	
}
