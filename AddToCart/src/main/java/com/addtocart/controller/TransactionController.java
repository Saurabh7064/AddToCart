package com.addtocart.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addtocart.dto.Cart;
import com.addtocart.service.CartService;
import com.addtocart.service.TransactionService;

@Controller
public class TransactionController {

	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/transaction/{cartid}")
	public String finishTransaction(Map<String, Object> map, Principal principal,
			@PathVariable int cartid) {
		
		int result = transactionService.saveTransation(cartid);
		
		return "CartItems";
	}
}
