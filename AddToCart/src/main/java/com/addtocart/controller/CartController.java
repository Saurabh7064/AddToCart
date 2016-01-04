package com.addtocart.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/addtocart/{productid}")
	public String addToCart(Map<String, Object> map, Principal principal,@PathVariable int productid){
		
 		
		return "sf";
	}
}
