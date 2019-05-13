package com.test.struts2.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/app")
@Action(value="select", results = {
		@Result(name="success", location="/welcome.jsp"),
		@Result(name="error", location="/error.jsp")})
public class SelectAction {

	public SelectAction(){

		searchEngine = new ArrayList<String>();
		searchEngine.add("google.com");
		searchEngine.add("bing.com");
		searchEngine.add("yahoo.com");
		searchEngine.add("baidu.com");
	}

	public String execute() throws Exception {
		return ActionSupport.SUCCESS;
	}

	public String display() {
		return ActionSupport.NONE;
	}

	private List<String> searchEngine;
	private String yourSearchEngine;
	private String yourMonth;


	public String getYourMonth() {
		return yourMonth;
	}

	public void setYourMonth(String yourMonth) {
		this.yourMonth = yourMonth;
	}

	public List<String> getSearchEngine() {
		return searchEngine;
	}

	public void setSearchEngine(List<String> searchEngine) {
		this.searchEngine = searchEngine;
	}

	public String getYourSearchEngine() {
		return yourSearchEngine;
	}

	public void setYourSearchEngine(String yourSearchEngine) {
		this.yourSearchEngine = yourSearchEngine;
	}

	public String getDefaultSearchEngine() {
		return "yahoo.com";
	}

}
