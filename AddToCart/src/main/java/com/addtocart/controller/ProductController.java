package com.addtocart.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.addtocart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/productlist")
	public String productList(Map<String, Object> map, Principal principal){
       map.put("productlist",productService.listProduct());
       if(principal != null){
			String name = principal.getName();
			map.put("username", name);
			}
		return "products";
	}
	
	@RequestMapping("/product/{id}")
	public String product(Map<String,Object> map,@PathVariable("id") int productID){
		
		
		map.put("product",productService.getProduct(productID));
		
		return "product";
	}
	
}
