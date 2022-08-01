package com.online.application1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Authentication {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer userId;
	
	private String password;
	
	
	@OneToOne
	private Admin admin;
	
	@OneToOne 
	private Customer customer;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Authentication(Integer userId, String password, Admin admin, Customer customer) {
		super();
		this.userId = userId;
		this.password = password;
		this.admin = admin;
		this.customer = customer;
	}

	public Authentication() {
		super();
		
	}

	@Override
	public String toString() {
		return "Authentication [userId=" + userId + ", admin=" + admin + ", customer=" + customer + "]";
	}
	
	
	

}
