package com.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "productcategory" ,path ="product-category")
@CrossOrigin("http://localhost:4200")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	public Optional<ProductCategory> findById(Long id);

	public Optional<ProductCategory> findByCategoryName(String category_name);
}
