package com.online.application1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.application1.dao.ProductRepository;
import com.online.application1.dto.Product;
import com.online.application1.exception.ProductException;

@Repository
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepo;

	@Override
	public Boolean addProduct(Product productObj) throws ProductException {

		if (productObj == null) {
			return false;
		}
		
		Boolean success = false;
		Optional<Product> product2 = this.productRepo.findById(productObj.getProductId());
		
		if (product2.isPresent()) {
			
			throw new ProductException("Given ProductId :" + productObj.getProductId() + " already Exists try Another ProductId");
		} 
		
		else {
			
			this.productRepo.save(productObj);
			success = true;
		}
		return success;
	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		
		Optional<Product> product = this.productRepo.findById(productId);
		if (product.isEmpty()) {
			
			throw new ProductException("Given productId : " + productId +  "  Does not Exist");
		}
		return product.get();
	 
		 
		 
	}

	@Override
	public Product updateProduct(Product productObj) throws ProductException {

      Optional<Product> productdb= this.productRepo.findById(productObj.getProductId());
		
		if(productdb.isEmpty()) {
			throw new ProductException("id "  +productObj.getProductId()+ "  doesn't exist ");
		}
	
		
		
		return this.productRepo.save(productObj);
	}

	@Override
	public void deleteProductById(Integer productId) throws ProductException {

		   Optional<Product> product = this.productRepo.findById(productId);
			
			if (product.isEmpty()) {
				
				throw new ProductException("productId" + productId + " Does not exist");
			} 
			
			else {
				
				this.productRepo.deleteById(productId);
				
			}
		
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {

		return this.productRepo.findAll();
	}
	
	@Override
	public long countProducts() throws ProductException{
		return productRepo.count();
	}

}
