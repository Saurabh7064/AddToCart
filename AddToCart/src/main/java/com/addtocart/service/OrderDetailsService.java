package com.addtocart.service;

import com.addtocart.dto.OrderDetails;


public interface OrderDetailsService {
    public OrderDetails saveOrderDetails();
	
	public OrderDetails isItemExisting(int productid);
}
