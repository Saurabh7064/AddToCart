package com.addtocart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addtocart.dao.UserDao;
import com.addtocart.dto.User;
import com.addtocart.service.UserService;

@Service
public class UserServiceImpl implements UserService   {

	@Autowired
 private UserDao userDao;
	

	@Transactional
	public void saveUser(User user) {
		userDao.saveUser(user); 
	}
	
	@Transactional(readOnly = true)
	public List<User>  listUser() {
		return userDao.listUser(); 
	}

	@Transactional(readOnly = true)
	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}

	@Transactional
	public int deleteUser(int userID) {
		return userDao.deleteUser(userID);
	}

	 

}
