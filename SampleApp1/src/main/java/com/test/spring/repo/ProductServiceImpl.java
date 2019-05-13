package com.test.spring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.spring.model.Product;

@Controller
@RequestMapping("/product")
public class ProductServiceImpl {

	@Autowired
	private ProductRepo prodRepo;

	@Transactional
	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		Product product = null;
		Optional<Product> prodById = prodRepo.findById(id);
		if(prodById.isPresent())
			System.out.println("Product from DB : "+prodById.get().getName());
		product = prodById.get();
		return product;
	}

	@Transactional
	@GetMapping("/all")
	public List<Product> findAll() {
		return prodRepo.findAll();
	}

	@Transactional
	@PostMapping("/add")
	public Product add(@RequestBody Product product) {
		Product prod = prodRepo.save(product);
		if(prod!=null)
			System.out.println("Added : "+prod.getName());
		return prod;
	}
}
