package com.addtocart.service;

import java.util.List;

import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.User;

public interface CartService {
    //public Integer saveCart(Cart cart)  ;
	
	public Integer saveCart(User user,int productid);
	
	public Cart isCartExisting(int userID);
	
	public Cart getCart(int cartid);
	
	public int saveCart(User user, int id, int productid);
	
	public int getCartQuantity(List<OrderDetails> orderDetails);
	
	public int getCartAmount(List<OrderDetails> orderDetails);
	
	
}
