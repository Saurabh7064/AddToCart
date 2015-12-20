package com.addtocart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String HelloWorld(){
		
		return "/index";
	}
	
	
}
