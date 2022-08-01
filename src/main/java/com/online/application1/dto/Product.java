package com.online.application1.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private Integer productId;
	
	private Double productPrice;
	
	private String productName;
	
	private long quantity;
	
	

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productPrice=" + productPrice + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}

	public Product(Integer productId, Double productPrice, String productName, long quantity) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.quantity = quantity;
	}

	public Product() {
		super();
		
	}

	
    
	
 

}
