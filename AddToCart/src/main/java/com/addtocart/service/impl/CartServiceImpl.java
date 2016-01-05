package com.addtocart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addtocart.dao.CartDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;
import com.addtocart.dto.User;
import com.addtocart.service.CartService;
import com.addtocart.service.OrderDetailsService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
    @Autowired
	private OrderDetailsService orderDetailsService;
	@Override
	@Transactional
	public Integer saveCart(User user, int productid) {
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

		int result = cartDao.saveCart(cart);
		System.out.println(result);
		return result;
	}

	@Override
	@Transactional
	public int saveCart(User user, int cartid, int productid) {
		Cart cart = cartDao.getCart(cartid);
        //is order details existing with given product id?
		OrderDetails isItemExisting = orderDetailsService.isItemExisting(productid);
		if(isItemExisting!=null){
			//add in existing
			isItemExisting.setQuantity(isItemExisting.getQuantity()+1);

		   List<OrderDetails> listOfOrders = new ArrayList<OrderDetails>();
			listOfOrders.add(isItemExisting);

			cart.setOrderDetails(listOfOrders);

			int result = cartDao.saveCart(cart);
			System.out.println(result);
			return result;
		}else{
			//new 
			Product product = new Product(productid,1);

			OrderDetails orderDetails1 = new OrderDetails();
			orderDetails1.setUser(cart.getUser());
			orderDetails1.setProducts(product);
			orderDetails1.setCart(cart);

			List<OrderDetails> listOfOrders = new ArrayList<OrderDetails>();
			listOfOrders.add(orderDetails1);

			cart.setOrderDetails(listOfOrders);

			int result = cartDao.saveCart(cart);
			System.out.println(result);
			return result;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cart isCartExisting(int userID) {
		return cartDao.isCartExisting(userID);
	}

}
