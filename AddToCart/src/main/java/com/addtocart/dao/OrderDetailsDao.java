package com.addtocart.dao;

import com.addtocart.dto.OrderDetails;

public interface OrderDetailsDao {

	public OrderDetails saveOrderDetails();
	
	public OrderDetails isItemExisting(int productid);
	
}
