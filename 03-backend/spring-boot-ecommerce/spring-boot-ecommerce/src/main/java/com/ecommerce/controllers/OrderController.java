package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.User;
import com.ecommerce.service.OrderService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
	@Autowired
	OrderService orderService;
	@PostMapping("/orders")
	public List<Order> findUserById(@RequestBody User user) {
		return orderService.findAll(user);
		
	}
	@PostMapping("/orders/orderitems")
	public List<OrderItem> findUserById(@RequestBody Order trackingNumber) {
		return orderService.findorderItems(trackingNumber.getOrderTrackingNumber());
		
	}

}
