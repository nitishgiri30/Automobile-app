package com.online.application1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.application1.dto.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
