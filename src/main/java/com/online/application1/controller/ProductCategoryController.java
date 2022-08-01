package com.online.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.application.dto.Category;
import com.online.application.exception.ProductCategoryException;
import com.online.application.services.ProductCategoryServiceImpl;


@RestController
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryServiceImpl productCategoryService;

	@PostMapping("productcategory")
	public Category createProductCategory(@RequestBody Category productCategory) throws ProductCategoryException {
   
		return this.productCategoryService.addProductCategory(productCategory); 

	}

	@PutMapping("updateproductcategory")
	public Category updateProductCategory(@RequestBody Category productCategory) throws ProductCategoryException {

		return this.productCategoryService.updateProductCategory(productCategory);

	}

	@GetMapping("productcategory/{id}")
	public Category getProductCategoryById(@PathVariable("id") Integer id) throws ProductCategoryException {

		return this.productCategoryService.getProductCategoryById(id);

	}

	@GetMapping("productcategory/all")
	public List<Category> getAllProductCategories() throws ProductCategoryException {

		return this.productCategoryService.getAllProductCategories();

	}

	@DeleteMapping("productcategory/{id}")
	public void deleteProductCategoryById(@PathVariable("id") Integer id) throws ProductCategoryException {

		this.productCategoryService.deleteProductCategoryById(id);
		System.out.println("Delete ProductCategory id:" + id);

	}
    
	@GetMapping("productcategoryCount")
	public Long getProductProductById() throws ProductCategoryException {

		return this.productCategoryService.getCountOfProductCategories();

	}


}
