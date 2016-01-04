package com.addtocart.dao;

import java.util.List;

import com.addtocart.dto.Product;

public interface ProductDao {

	 public void saveProduct(Product product);
     public List<Product> listProduct();
	 public Product getProduct(int id);

	
}
