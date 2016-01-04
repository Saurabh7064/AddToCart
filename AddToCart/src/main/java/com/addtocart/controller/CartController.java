package com.addtocart.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;
import com.addtocart.dto.User;
import com.addtocart.service.CartService;
import com.addtocart.service.UserService;

 
@Controller
public class CartController {
	
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	
	@RequestMapping("/addtocart/{productid}")
	public String addToCart(Map<String, Object> map, Principal principal,@PathVariable int productid){
		
		String name=null;
		 if(principal != null){
				  name = principal.getName();
   		}
		User user = userService.findUserByName(name);
		//create a new cart if status is 0
		/*System.out.println("find by username"+user.getName()+user.getId());
         Cart isCartExisting=cartService.isCartExisting(user.getId());
        if(isCartExisting!=null){
        	 //TODO check for cart with status 1        	 
             System.out.println("isCartExisting"+isCartExisting.getUser().getName());
      		map.put("name", isCartExisting.getUser().getName() )  ; 
      		
      		//create new user here after check
      		Cart cart = new Cart();
      		cart.setUser(user);
      		cart.setStatus(1);
         }*/
		 Product product = new Product(productid);

		Cart cart = new Cart();
		cart.setUser(user);
		cart.setStatus(0);
		
		 
		  OrderDetails orderDetails1 = new OrderDetails();
          orderDetails1.setUser(cart.getUser());
          orderDetails1.setProducts(product);
          orderDetails1.setCart(cart);
      
		 
		 List<OrderDetails> listOfOrders = new ArrayList<OrderDetails>();
         listOfOrders.add(orderDetails1);
         
         cart.setOrderDetails(listOfOrders);
     
         int result=cartService.saveCart(cart);
         System.out.println(result);
		return "index";
	}
}
