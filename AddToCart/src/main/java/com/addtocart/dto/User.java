package com.addtocart.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

 
@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer id;

	private String name;

	private String email;

	private String password;
	
	public User(Integer id) {
		super();
		this.id = id;
	}
	private int enabled;
	
	public User() {
		super();
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
			 
	private List<Role> roles;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Cart> carts ;
    

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails ;


	public int isEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    @com.fasterxml.jackson.annotation.JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
