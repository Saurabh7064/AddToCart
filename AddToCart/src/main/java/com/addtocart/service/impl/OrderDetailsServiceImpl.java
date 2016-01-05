package com.addtocart.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addtocart.dao.OrderDetailsDao;
import com.addtocart.dto.OrderDetails;
 import com.addtocart.service.OrderDetailsService;
 


@Repository
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	public OrderDetailsDao orderDetailsDao ; 
 
	@Override
	public OrderDetails saveOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public OrderDetails isItemExisting(int productid) {
		
		return orderDetailsDao.isItemExisting(productid);
		
	}
/*	User user = findOne(id);
	List<Blog> blogs = blogRepository.findByUser(user);
	for (Blog blog : blogs) {
		List<Item> items = itemRepository.findByBlog(blog );
		blog.setItems(items);
	}
	user.setBlogs(blogs);
	return user;*/
	@Override
	@Transactional
	public List<OrderDetails> getOrderDetailsByCartID(int cartID) {
		 
     return orderDetailsDao.getOrderDetailsByCartID(cartID);
     
	}

}
