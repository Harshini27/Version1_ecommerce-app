package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository; 
import com.ecommerce.repository.OrderItemRepository;
@Service
public class OrderService {
	private OrderItemRepository orderItemRepository;
	private OrderRepository orderRepository;
	private UserRepository userRepository;
	
	public OrderService(OrderRepository orderRepository,UserRepository userRepository,OrderItemRepository orderItemRepository)
  {
	this.orderRepository=orderRepository;
	this.userRepository=userRepository;
	this.orderItemRepository=orderItemRepository;
  }
	public List<Order> findAll(User user) {
		user=userRepository.findByEmail(user.getEmail());
		return orderRepository.findByUserid(user.getUserid());
		
	}
	public List<OrderItem> findorderItems(String trackingNumber) {
		
		return  orderItemRepository.findByOrderid(orderRepository.findByOrderTrackingNumber(trackingNumber).getId());
		
		
	}
	
	
	

}
