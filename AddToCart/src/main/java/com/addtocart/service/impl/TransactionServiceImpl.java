package com.addtocart.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addtocart.dao.TransactionDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.Transactions;
import com.addtocart.service.CartService;
import com.addtocart.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	CartService cartService;
	@Autowired
	TransactionDao transactionDao;
 	@Override
	@Transactional
	public int saveTransation(int cartid) {
		Cart cart = cartService.getCart(cartid);
		cart.setStatus(1);
		Transactions transaction = new Transactions();
		transaction.setCart(cart);
		return	transactionDao.saveTransation(transaction);
	 
	}

}
