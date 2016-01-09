package com.addtocart.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "product_price")
	private int price;
	
	@Column(name="product_stock")
	private int stock;
	
	@Column(name="product_description")
	private String description;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

 
	public Product() {
		super();
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", description="
				+ description + ", orderDetails=" + orderDetails + "]";
	}

 
 
	 

}
