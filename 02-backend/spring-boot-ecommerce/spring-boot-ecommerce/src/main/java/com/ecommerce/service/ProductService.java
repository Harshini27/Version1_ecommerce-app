package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductCategoryRepository;
import com.ecommerce.entity.ProductCategory;
import com.ecommerce.entity.User;

@Service
public class ProductService {
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public ProductCategory findById(Long id) {
		Optional<ProductCategory> optional = productCategoryRepository.findById(id);
		return optional.orElse(null);
	}

}
