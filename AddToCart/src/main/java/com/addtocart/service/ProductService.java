package com.addtocart.service;

import java.util.List;

import com.addtocart.dto.OrderDetails;
import com.addtocart.dto.Product;

public interface ProductService {
	
	 public void saveProduct(Product product);
     public List<Product> listProduct();
	 public Product getProduct(int id);
	 
 	
}
