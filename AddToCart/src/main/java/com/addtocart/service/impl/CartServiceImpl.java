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
		System.out.println("Entered new cart");
		Product product = new Product(productid);

		Cart cart = new Cart();
		cart.setUser(user);
		cart.setStatus(0);

		OrderDetails orderDetails1 = new OrderDetails();
		orderDetails1.setUser(cart.getUser());
		orderDetails1.setProducts(product);
		orderDetails1.setQuantity(1);
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
		OrderDetails isItemExisting = orderDetailsService.isItemExisting(cartid,productid);
		if(isItemExisting!=null){
			System.out.println("Entered if");
			//add in existing
			isItemExisting.setQuantity(isItemExisting.getQuantity()+1);

		   List<OrderDetails> listOfOrders = new ArrayList<OrderDetails>();
			listOfOrders.add(isItemExisting);

			cart.setOrderDetails(listOfOrders);

			int result = cartDao.saveCart(cart);
			System.out.println(result);
			return result;
		}else{
			System.out.println("Entered else");
			Product product = new Product(productid);

			OrderDetails orderDetails1 = new OrderDetails();
			orderDetails1.setUser(cart.getUser());
			orderDetails1.setProducts(product);
			orderDetails1.setQuantity(1);

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

	@Override
	public int getCartQuantity(List<OrderDetails> orderDetails) {
		int totalQuantity=0;
 		for(OrderDetails  Quantity:orderDetails){
			totalQuantity+=Quantity.getQuantity();
 		}
		System.out.println("totalQuantity "+totalQuantity);
		return totalQuantity;
 	}

	@Override
	public int getCartAmount(List<OrderDetails> orderDetails) {
 		int totalAmount=0;
		for(OrderDetails  Price:orderDetails){
 			totalAmount+=Price.getQuantity()*Price.getProducts().getPrice();
		}
 		System.out.println("totalAmount "+totalAmount);
 		return totalAmount;
	}

	@Override
	@Transactional
	public Cart getCart(int id) {
 		return cartDao.getCart(id);
	}

}
