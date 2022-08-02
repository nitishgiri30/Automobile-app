package com.online.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.application.dao.ProductCategoryRepository;
import com.online.application.dto.Category;
import com.online.application.dto.Product;
import com.online.application.exception.ProductCategoryException;


@Repository
public class ProductCategoryServiceImpl implements ProductCategoryService{

	
	@Autowired
	ProductCategoryRepository productCategoryRepo;

	@Override
	public Category addProductCategory(Category category) throws ProductCategoryException {
		
		return this.productCategoryRepo.save(category);
	}

	@Override
	public Category getProductCategoryById(Integer categoryId) throws ProductCategoryException {

		java.util.Optional<Category> category = this.productCategoryRepo.findById(categoryId);
		if (category.isEmpty())
			throw new ProductCategoryException("SORRY Category Field Is Null");
		return category.get();
	}

	@Override
	public Category updateProductCategory(Category category) throws ProductCategoryException {
		java.util.Optional<Category> categorydb = this.productCategoryRepo.findById(category.getCategoryID());

		if (categorydb.isEmpty()) {
			throw new ProductCategoryException("id " + category.getCategoryID() + "  doesn't exist ");
		}

		return this.productCategoryRepo.save(category);
	}

	@Override
	public void deleteProductCategoryById(Integer categoryId) throws ProductCategoryException {
		
		this.productCategoryRepo.deleteById(categoryId);
		
	}

	@Override
	public List<Category> getAllProductCategories() throws ProductCategoryException {
		
		return this.productCategoryRepo.findAll();
	}

	@Override
	public Long getCountOfProductCategories() throws ProductCategoryException {
		
		return this.productCategoryRepo.count();
	}
}
