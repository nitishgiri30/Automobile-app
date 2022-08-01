package com.online.application1.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	
	@Id
	private Integer categoryID;
	
	private String categoryName;
	
	
     @OneToMany(cascade = CascadeType.ALL)
     private List<Product> products=new ArrayList<>();


	public Integer getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Category(Integer categoryID, String categoryName, List<Product> products) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.products = products;
	}


	public Category() {
		super();

	}


	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", products=" + products + "]";
	}
     
     
	
}
