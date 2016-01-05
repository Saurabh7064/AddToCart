package com.addtocart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addtocart.dao.ProductDao;
import com.addtocart.dto.Cart;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;
@Repository
public   class ProductDaoImpl implements ProductDao{

	 @Autowired
	 private SessionFactory sessionFactory;
	 
 	    @SuppressWarnings("unchecked")
	    public List<Product> listProduct() {
			Criteria c = getSession().createCriteria(Product.class);		
			c.addOrder(Order.desc("name"));
			return c.list();
		}
	 
 	   public Product getProduct(int id) {
 			return (Product) getSession().get(Product.class, id);

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


		public void saveProduct(Product product) {
			// TODO Auto-generated method stub
			
		}

		 

		
}
