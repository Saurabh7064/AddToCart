package com.addtocart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addtocart.dao.ProductDao;
import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;
import com.addtocart.service.ProductService;
@Service
public   class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductDao productDao;
	
	@Transactional(readOnly = true)
	public List<Product>  listProduct() {
		return productDao.listProduct(); 
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	@Transactional(readOnly = true)

	public Product getProduct(int id) {				
		return productDao.getProduct(id);

	}

	 
}
