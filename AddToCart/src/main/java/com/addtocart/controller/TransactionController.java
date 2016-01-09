package com.addtocart.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.addtocart.service.TransactionService;

@Controller
public class TransactionController {

	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="/transaction/{cartid}/{totalamount}",method=RequestMethod.GET)
	public String finishTransaction(Map<String, Object> map, Principal principal,
			@PathVariable int cartid,@PathVariable int totalamount) {
		
		int result = transactionService.saveTransation(cartid);
		 map.put("totalamount", totalamount);
            
		return "checkout";
	}
	
	/*@RequestMapping("/checkout")
	public String checkout() {
		return "checkout";
	}*/
}
