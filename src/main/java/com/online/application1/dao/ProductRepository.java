package com.online.application1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.application1.dto.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	

}
