package com.addtocart.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addtocart.dao.TransactionDao;
import com.addtocart.dto.Transactions;
@Repository
public class TransactionDaoImpl implements TransactionDao {
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 
	public int saveTransation(Transactions transaction) {
	return	(int) getSession().save(transaction);
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
