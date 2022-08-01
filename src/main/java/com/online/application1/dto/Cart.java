package com.online.application1.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Cart {
	 
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer cartId;
	private Double amount;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> product= new ArrayList<>();


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", amount=" + amount + ", product=" + product + "]";
	}


	public Cart(Integer cartId, Double amount, List<Product> product) {
		super();
		this.cartId = cartId;
		this.amount = amount;
		this.product = product;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	



	
	
	

}

	