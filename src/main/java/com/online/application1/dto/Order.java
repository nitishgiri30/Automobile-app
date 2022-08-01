package com.online.application1.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer orderId;
	
	private String orderStatus;
	private Date orderDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payment Payment;
	
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 private List<Product> products=new ArrayList<>();


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Payment getPayment() {
		return Payment;
	}


	public void setPayment(Payment payment) {
		Payment = payment;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", Payment="
				+ Payment + ", products=" + products + "]";
	}


	public Order(Integer orderId, String orderStatus, Date orderDate, Payment payment,
			List<Product> products) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.Payment = payment;
		this.products = products;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	



	

	

	
	
	
	

}
