package com.addtocart.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.addtocart.dao.CartDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.User;

public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveCart(Cart cart) {

		return (Integer) getSession().save(cart);
	}

	@Override
	public Cart isCartExisting(int userID) {

		Criteria c = getSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("user", new User(userID))).add(
				Restrictions.eq("status", new Integer(0)));
		return (Cart) c.uniqueResult();
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
	public Cart getCart(int id) {
		Cart cart = (Cart) getSession().get(Cart.class, new Integer(id));

		return cart;
	}
}
