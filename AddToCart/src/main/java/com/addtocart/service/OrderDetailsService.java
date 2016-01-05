package com.addtocart.service;

import java.util.List;

import com.addtocart.dto.OrderDetails;


public interface OrderDetailsService {
    public OrderDetails saveOrderDetails();
	
	public OrderDetails isItemExisting(int productid);
	
	public List<OrderDetails> getOrderDetailsByCartID(int cartID);
}
