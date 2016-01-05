package com.addtocart.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.User;
import com.addtocart.service.CartService;
import com.addtocart.service.OrderDetailsService;
import com.addtocart.service.UserService;

@Controller
public class CartController {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	OrderDetailsService orderService;

	@RequestMapping("/addtocart/{productid}")
	public String addToCart(Map<String, Object> map, Principal principal,
			@PathVariable int productid) {

		String name = null;
		if (principal != null) {
			name = principal.getName();
		}
		User user = userService.findUserByName(name);
		Cart isCartExisting = cartService.isCartExisting(user.getId());
		if (isCartExisting != null) {
			int result = cartService.saveCart(user, isCartExisting.getId(),
					productid);
		} else {
			int result = cartService.saveCart(user, productid);
		}
		return "redirect:/productlist";

	}
	
	@RequestMapping("/displaycart")
	public String displayCart(Map<String, Object> map, Principal principal) {
		String name = null;
		if (principal != null) {
			name = principal.getName();
		}
		User user = userService.findUserByName(name);
		
		Cart isCartExisting = cartService.isCartExisting(user.getId());
		
		List<OrderDetails> od = orderService.getOrderDetailsByCartID(isCartExisting.getId());
		
		for(OrderDetails od2:od){
		System.out.println(od2.getProducts());	
		}
		
		return "redirect:/productlist";
	}
}
