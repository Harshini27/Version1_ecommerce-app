package com.ecommerce.dto;
import java.util.Set;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.User;

import lombok.Data;

@Data
public class Purchase {
    private User user;
    private Order order;
    private Set<OrderItem> orderItems;

}
