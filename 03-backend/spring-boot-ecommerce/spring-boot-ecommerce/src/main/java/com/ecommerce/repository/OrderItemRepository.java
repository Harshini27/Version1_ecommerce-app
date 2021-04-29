package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;


@CrossOrigin("http://localhost:4200")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findByOrderid(Long id);

}


