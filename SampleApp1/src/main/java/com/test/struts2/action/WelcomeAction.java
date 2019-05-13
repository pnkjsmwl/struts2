package com.test.struts2.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.test.spring.model.Product;
import com.test.struts2.domain.product.ProductDomain;

@Namespace(value="/")
public class WelcomeAction {

	private List<Product> products;
	private ProductDomain productDomain;

	public WelcomeAction(ProductDomain productDomain) {
		this.productDomain = productDomain;
	}

	@Action(value="welcome", results = {
			@Result(name="success", location="welcome.jsp")})
			//@Result(name="success", location="app/validation/login.jsp")})
	public String execute() throws Exception {
		System.out.println("Welcome Action !!");

		products = productDomain.getAll();
		products.forEach(System.out::println);

		return ActionSupport.SUCCESS;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
