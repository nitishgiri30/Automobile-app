package com.online.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.application.dto.Category;



@Repository
public interface ProductCategoryRepository extends JpaRepository<Category,Integer>{

}
