package com.addtocart.dao;

import com.addtocart.dto.Cart;
import com.addtocart.dto.User;

public interface CartDao {


 public Integer  saveCart(Cart cart) ;
	 
	public Cart isCartExisting(int userID);
	
	public Cart getCart(int id);
	
}
