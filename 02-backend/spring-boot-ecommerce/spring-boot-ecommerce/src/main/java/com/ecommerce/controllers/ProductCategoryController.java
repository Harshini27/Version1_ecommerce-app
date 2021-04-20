package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.ProductCategoryRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;
import com.ecommerce.entity.User;
import com.ecommerce.service.ProductService;



@RestController
@CrossOrigin("http://localhost:4200")
public class ProductCategoryController {
	@Autowired
	ProductService productService;
	@Autowired
	public ProductCategoryRepository productCategoryRepository;
	@Autowired
	public ProductRepository productRepository;
	@GetMapping("/categories/{id}")
	public List<Product> findUserById(@PathVariable(required=true) Long id) {
		return productRepository.findByCategoryId(id);
	}
		
//		@GetMapping("/api/product-category/{id}")
//		public ProductCategory findACategory(@PathVariable(required=true) Long id) {
//			return productCategoryRepository.findById(id).orElse(null);}
//		
		@GetMapping("/categories")
      	public List<ProductCategory> findAllProductcategories() {
			return productCategoryRepository.findAll();
	   }
	
	}
