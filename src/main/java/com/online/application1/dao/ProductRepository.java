package com.online.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.application.dto.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	

}
