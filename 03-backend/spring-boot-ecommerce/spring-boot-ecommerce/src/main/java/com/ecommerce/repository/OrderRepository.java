package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entity.Order;


@CrossOrigin("http://localhost:4200")
public interface OrderRepository extends JpaRepository<Order, Long> {
	public Optional<Order> findById(Long id);

	public List<Order> findByUserid(int userid);

	public Order findByOrderTrackingNumber(String orderTrackingNumber);
}

