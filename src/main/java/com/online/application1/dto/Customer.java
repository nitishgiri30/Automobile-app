package com.online.application1.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer userId;
	
	private String userName;
	private String contactNo;
	private String email;
	
    private Integer houseNo;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private Integer pincode;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	
	@OneToMany(cascade = CascadeType.ALL)
  private List<Order> orders=new ArrayList<>();


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Integer getPincode() {
		return pincode;
	}


	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Customer(Integer userId, String userName, String contactNo, String email, Integer houseNo, String street,
			String city, String state, Integer pincode, Cart cart, List<Order> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contactNo = contactNo;
		this.email = email;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.cart = cart;
		this.orders = orders;
	}


	public Customer() {
		super();

	}


	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ", contactNo=" + contactNo + ", email=" + email
				+ ", houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", cart=" + cart + ", orders=" + orders + "]";
	}
	
	
	
	
	
	
	

}
