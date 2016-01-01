package com.addtocart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addtocart.dao.UserDao;
import com.addtocart.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void saveUser(User user) {
		getSession().merge(user);
		
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		Criteria c = getSession().createCriteria(User.class);		
		c.addOrder(Order.desc("name"));
		return c.list();
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
	
}
