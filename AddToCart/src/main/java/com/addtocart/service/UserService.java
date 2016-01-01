package com.addtocart.service;

import java.util.List;

import com.addtocart.dto.User;

public interface UserService {

	 public void saveUser(User user);
     public List<User> listUser();
	
}
