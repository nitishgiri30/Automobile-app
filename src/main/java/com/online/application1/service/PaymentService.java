package com.online.application1.service;

import java.util.List;

import com.online.application1.dto.Payment;
import com.online.application1.exception.PaymentException;



public interface PaymentService {

	
    Payment addPayment(Payment paymentObj) throws PaymentException;
	
	Payment getPaymentById(Integer paymentId) throws PaymentException;
	
	Payment updatePayment(Payment paymentObj) throws PaymentException;
	
	void deletePaymentById(Integer paymentId) throws PaymentException;
	
	 List<Payment> getAllPayment() throws PaymentException;
	 
}
