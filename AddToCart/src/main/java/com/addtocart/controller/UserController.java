package com.addtocart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/*------------------------------------------*/
	@RequestMapping("/listusersjson"  )
	public ResponseEntity<Iterable<User>> getListofUsersJson() {
		Iterable<User>	 users = userService.listUser(); 
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
	
	@RequestMapping("/ajaxuser")
	public String ajaxUser( ){
		
		return "usersajax";
	}
	
	
	//delete user
	@RequestMapping(value="/ajaxuserr/{userid}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable int userid) {
		int result=userService.deleteUser(userid);
		System.out.println("result"+result);
	 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	 
	
	
}
