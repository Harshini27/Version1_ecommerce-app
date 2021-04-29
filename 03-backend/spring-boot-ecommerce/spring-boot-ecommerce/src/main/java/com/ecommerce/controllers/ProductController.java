package com.ecommerce.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.ProductCategoryRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;
import com.ecommerce.entity.User;
import com.ecommerce.service.ProductService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

	public ProductRepository productRepository;

	public ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService,ProductRepository productRepository)
	{
		this.productService=productService;
		this.productRepository=productRepository;
	}
	

	@GetMapping("/api/products/{id}")
	public Product findAProduct(@PathVariable(required=true) Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/api/products")
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}


	@PostMapping("/api/admin/addProduct")
	public ResponseEntity<Product> createPoduct(@RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		ResponseEntity<Product> res = ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
		System.out.println(res);
		return res;

		}

}
