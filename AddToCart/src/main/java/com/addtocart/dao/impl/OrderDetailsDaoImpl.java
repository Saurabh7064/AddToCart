package com.addtocart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.addtocart.dao.OrderDetailsDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;
import com.addtocart.dto.User;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public OrderDetails saveOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails isItemExisting(int cartid,int productid) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(OrderDetails.class);
		c.add(Restrictions.eq("products", new Product(productid)))
		.add(Restrictions.eq("cart", new Cart(cartid)));
		return (OrderDetails) c.uniqueResult();
	 
	}
	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderDetails> getOrderDetailsByCartID(int cartID) {
	 
				Criteria c = getSession().createCriteria(OrderDetails.class);		
				c.add(Restrictions.eq("cart", new Cart(cartID))) ;
				return c.list();
			 
	}
}
