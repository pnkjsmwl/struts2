package com.test.struts2.domain.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.model.Product;
import com.test.spring.repo.ProductServiceImpl;

public class ProductDomain {

	@Autowired
	private ProductServiceImpl productService;
	
	public List<Product> getAll(){
		return productService.findAll();
	}
}
