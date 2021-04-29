package com.ecommerce.controllers;

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
public class ProductCategoryController {
	
	 public ProductService productService;
	public ProductCategoryRepository productCategoryRepository;
	public ProductRepository productRepository;
	
	@Autowired
	public ProductCategoryController(ProductService productService,ProductCategoryRepository productCategoryRepository,ProductRepository productRepository)
	{
		this.productCategoryRepository=productCategoryRepository;
		this.productRepository=productRepository;
		this.productService=productService;
	}
	@GetMapping("/api/products/categories/{id}")
	public List<Product> findUserById(@PathVariable(required=true) Long id) {
		return productRepository.findByCategoryId(id);
	}
		
//		@GetMapping("/api/product-category/{id}")
//		public ProductCategory findACategory(@PathVariable(required=true) Long id) {
//			return productCategoryRepository.findById(id).orElse(null);}
//		
		@GetMapping("/api/products/categories")
      	public List<ProductCategory> findAllProductcategories() {
			return productCategoryRepository.findAll();
	   }
		@PostMapping("/api/admin/addCategory")
		public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategory productCategory) {
			ProductCategory savedProductCategory = productService.createProductCategory(productCategory);
			ResponseEntity<ProductCategory> res = ResponseEntity.status(HttpStatus.CREATED).body(savedProductCategory);
			System.out.println(res);
			return res;

			}
	
	}
