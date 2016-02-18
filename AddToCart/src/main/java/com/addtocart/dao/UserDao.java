package com.addtocart.dao;

import java.util.List;

import com.addtocart.dto.User;

public interface UserDao {

     public void saveUser(User user);
     public List<User> listUser();
     public User findUserByName(String name); 
     public int deleteUser(int userID);

}
