package com.online.application.services;

import java.util.List;

import com.online.application.dto.Category;
import com.online.application.exception.ProductCategoryException;

public interface ProductCategoryService { 
    Category addProductCategory(Category category) throws ProductCategoryException;
	
    Category getProductCategoryById(Integer categoryId) throws ProductCategoryException; 
	
    Category updateProductCategory(Category category) throws ProductCategoryException;
	
	void deleteProductCategoryById(Integer categoryId) throws ProductCategoryException;
	
	List<Category> getAllProductCategories() throws ProductCategoryException;  
	
	Long getCountOfProductCategories() throws ProductCategoryException;

}
