package com.online.application1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.application1.dto.Product;
import com.online.application1.exception.ProductException;
import com.online.application1.service.ProductServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	 
	  @PostMapping("/product")
		public String createProduct(@RequestBody  Product product) throws ProductException {
			
			 this.productService.addProduct(product);
			 
			 return "Product Added Successfully ...";
			
		}
	  
	  @PutMapping("/updateProduct")
		public String updateProduct(@RequestBody  Product product) throws ProductException {
			
			 this.productService.updateProduct(product);
			 
			 return "Product Updated Successfully ...";
			
		}
	  
	  @GetMapping("/product/{id}")
		public Product getProductById(@PathVariable("id")  Integer id) throws ProductException {
			
			return this.productService.getProductById(id);
			
		}
	  
		@GetMapping("/product/all")
		public List<Product> getAllProducts() throws ProductException {
			
			
			return this.productService.getAllProduct();
			
		}
		
		 @DeleteMapping("/product/{id}")
			public String deleteProductById(@PathVariable("id") Integer id) throws ProductException {
				
				  this.productService.deleteProductById(id);
				  
				  return " Product Deleted Successfully ...";
				
				}
		 
		 @GetMapping("/countProducts")
		   public long countProduct() throws ProductException{
			    return this.productService.countProducts();
			    
		   }
	

}
