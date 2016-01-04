package com.addtocart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "transactions")
public class Transactions {

	
	@Id
    @GeneratedValue
    @Column(name = "transactions_id")	
   	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", cart=" + cart + "]";
	}
	
	
	
}
