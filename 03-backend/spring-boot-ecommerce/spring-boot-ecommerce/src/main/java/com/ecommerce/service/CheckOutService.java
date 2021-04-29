package com.ecommerce.service;

import com.ecommerce.dto.Purchase;
import com.ecommerce.dto.PurchaseResponse;

public interface CheckOutService {
	 PurchaseResponse placeOrder(Purchase purchase);

}
