package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entity.Product;


@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Long >{
	List<Product> findByCategoryId(Long id);
}
