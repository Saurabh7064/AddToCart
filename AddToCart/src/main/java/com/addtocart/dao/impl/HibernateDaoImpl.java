package com.addtocart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addtocart.dao.HibernateDao;
import com.addtocart.dto.HibernateDTO;

@Repository
public class HibernateDaoImpl implements HibernateDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveHibernateDTO(HibernateDTO hibernateDTO) {
		getSession().merge(hibernateDTO);
		
	}

	@SuppressWarnings("unchecked")
	public List<HibernateDTO> listHibernateDTO() {
		Criteria c = getSession().createCriteria(HibernateDTO.class);		
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
