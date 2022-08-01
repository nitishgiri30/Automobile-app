package com.online.application1.service;

import java.util.List;

import com.online.application1.dto.Product;

import com.online.application1.exception.ProductException;

public interface ProductService {

	
   Boolean addProduct(Product productObj) throws ProductException;
	
	Product getProductById(Integer productId) throws ProductException;
	
	Product updateProduct(Product productObj) throws ProductException;
	
	void deleteProductById(Integer productId) throws ProductException;
	
	 List<Product> getAllProduct() throws ProductException;
	 
	 public long countProducts() throws ProductException;
}
