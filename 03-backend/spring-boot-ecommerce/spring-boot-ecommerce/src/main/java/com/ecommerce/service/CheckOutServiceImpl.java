package com.ecommerce.service;

import javax.transaction.Transactional;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.Purchase;
import com.ecommerce.dto.PurchaseResponse;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.User;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;

@Service
public class CheckOutServiceImpl implements CheckOutService {
	private UserRepository userRepository;
	@Autowired
//	public CheckOutServiceImpl(UserRepository userRepository)
//	{
//		this.userRepository=userRepository;
//	}
	
	
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;
	@Autowired
	
	public CheckOutServiceImpl(OrderRepository orderRepository,UserRepository userRepository,OrderItemRepository orderItemRepository)
  {
	this.orderRepository=orderRepository;
	this.userRepository=userRepository;
	this.orderItemRepository=orderItemRepository;
  }
	
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        
//        orderItems.forEach(item -> order.add(item));
       
           User user = purchase.getUser();
           user=userRepository.findByEmail(user.getEmail());
//            user.add(order);
           order.setUserid(user.getUserid());
        
           // return a response
           orderRepository.save(order);
           Order order1=orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
           System.out.println(order1);
           orderItems.forEach(item -> {item.setOrderid(order1.getId());
           orderItemRepository.save(item);
           
           
           
           });
           
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }

}
