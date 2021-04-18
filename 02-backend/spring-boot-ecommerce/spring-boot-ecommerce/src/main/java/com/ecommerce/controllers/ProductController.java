package com.ecommerce.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;
	
	@GetMapping("/api/products/{id}")
	public Product findAProduct(@PathVariable(required=true) Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/api/products")
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}
}
