package com.addtocart.service.impl;

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

}
