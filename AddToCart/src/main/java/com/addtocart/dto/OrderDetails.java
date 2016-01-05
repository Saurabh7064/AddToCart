package com.addtocart.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue
    @Column(name = "orderdetails_id")	
	private int id;
    
    @Column(name = "product_quantity")	
	private int quantity;
	
	@ManyToOne(optional = false )
	@JoinColumn(name = "product_id")
	private Product products;
 
	@ManyToOne(optional = false )
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne(optional = false )
	@JoinColumn(name = "cart_id")
	Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity
				+ ", products=" + products + ", user=" + user + ", cart="
				+ cart + "]";
	}
	
	
}
