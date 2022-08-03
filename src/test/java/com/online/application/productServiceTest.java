package com.online.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.application.dto.Product;
import com.online.application.exception.ProductException;
import com.online.application.services.ProductService;

@SpringBootTest
public class productServiceTest {
	
	
	@Autowired
	private ProductService productService;
	
	@Test
	void deleteProductByIdTest() throws ProductException {
		assertTrue(this.productService.deleteProductById(2));
	}
	
//	@Test
//	void addProductTest() throws ProductException {
//		Product product=new Product(3,9999.0,"nano",5);
//		assertTrue(this.productService.addProduct(product));
//		assertNotNull(this.productService.getProductById(3));
//	}
	
//	@Test
//	void getProductByIdTest() throws ProductException {
//		
//		assertNotNull(this.productService.getProductById(3));
//	}
//	
//	@Test
//	void updateProductTest() throws ProductException {
//		
//		assertNotNull(this.productService.updateProduct(new Product(3,9999.0,"tata punch",10)));
//	}
//	
//	
//	
	
	@Test
	void getAllProductTest() throws ProductException {
		
		assertNotNull(this.productService.getAllProduct());
	}
//	
	@Test
	void countProductsTest() throws ProductException {
		
		
		assertNotNull(this.productService.countProducts());
	}
	

}
