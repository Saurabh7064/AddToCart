package com.addtocart.service;

import com.addtocart.dto.Cart;
import com.addtocart.dto.User;

public interface CartService {
    public Integer saveCart(Cart cart)  ;
	
	public Cart isCartExisting(int userID);
}
