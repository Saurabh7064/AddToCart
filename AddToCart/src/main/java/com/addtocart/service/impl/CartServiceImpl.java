package com.addtocart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addtocart.dao.CartDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.User;
import com.addtocart.service.CartService;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
    private CartDao cartDao;
	
	
	@Override
	@Transactional
	public Integer saveCart(Cart cart) {
		return cartDao.saveCart(cart);
	}

	@Override
	@Transactional(readOnly = true)
	public Cart isCartExisting(int userID) {
	return	cartDao.isCartExisting(userID);
	}

}
