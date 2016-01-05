package com.addtocart.service;

import com.addtocart.dto.Cart;
import com.addtocart.dto.User;

public interface CartService {
    //public Integer saveCart(Cart cart)  ;
	
	public Integer saveCart(User user,int productid);
	
	public Cart isCartExisting(int userID);

	public int saveCart(User user, int id, int productid);
}
