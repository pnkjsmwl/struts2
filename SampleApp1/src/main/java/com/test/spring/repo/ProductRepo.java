package com.test.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
