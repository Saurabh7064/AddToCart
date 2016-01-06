package com.addtocart.dao;

import java.util.List;

import com.addtocart.dto.OrderDetails;

public interface OrderDetailsDao {

	public OrderDetails saveOrderDetails();
	
	public OrderDetails isItemExisting(int cartid,int productid);
	
	public List<OrderDetails> getOrderDetailsByCartID(int cartID);
}
