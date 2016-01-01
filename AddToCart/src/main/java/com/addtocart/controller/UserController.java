package com.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.addtocart.dto.User;
import com.addtocart.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/registerform")
	public String constructRegisterForm(@ModelAttribute User user){
		
		return "UserRegistration";
	}
	
	@RequestMapping("/registeration")
	public String saveUser(@ModelAttribute User user){
		
		userService.saveUser(user);
		System.out.println("saved");
		return "redirect:/registerform?success=true";

	}
	
	@RequestMapping("/listusers")
	public ModelAndView getListofUsers() {
		List<User> users = userService.listUser(); 
		return new ModelAndView("UsersList","users",users);
	}
	
	
}
