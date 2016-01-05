package com.addtocart.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "cart")
public class Cart {
	
    @Id
    @GeneratedValue
    @Column(name = "cart_id")	
    private int id;
    @Column(name = "cart_status")	
	private int status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	
 
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails ;
  
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Transactions> transactions ;
    

	 
	public Cart() {
		super();
	}

	public Cart(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", status=" + status + ", user=" + user
				+ ", orderDetails=" + orderDetails + ", transactions="
				+ transactions + "]";
	}
  
}
