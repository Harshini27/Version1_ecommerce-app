package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductRequest;
import com.ecommerce.service.ProductService;
@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {
	@Autowired
    ProductService productService;
	
	
	@PostMapping("/api/admin/product")
	public ResponseEntity<ProductRequest> createPoductWithCategory(@RequestBody ProductRequest productRequest) {
		ProductRequest savedProduct = productService.createProductWithCategory(productRequest);
		ResponseEntity<ProductRequest> res = ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
		System.out.println(res);
		return res;

		}
}
