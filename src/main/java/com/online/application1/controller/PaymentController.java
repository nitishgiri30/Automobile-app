package com.online.application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.application1.dto.Payment;
import com.online.application1.exception.PaymentException;
import com.online.application1.service.PaymentServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PaymentController {

	@Autowired 
	PaymentServiceImpl  paymentService;
	
	
	@PostMapping("payment")
	public Payment createPayment(@RequestBody  Payment payment) throws PaymentException {
		
		return this.paymentService.addPayment(payment);
		
	}

@PutMapping("updatePayment")
public Payment updatePayment(@RequestBody  Payment payment) throws PaymentException {
	
	return this.paymentService.updatePayment(payment);
	
}

@GetMapping("payment/{id}")
public Payment getPaymentById(@PathVariable("id")  Integer id) throws PaymentException {
	
	return this.paymentService.getPaymentById(id);
	
}

@GetMapping("payment/all")
public List<Payment> getAllPayments() throws PaymentException {
	
	
	return this.paymentService.getAllPayment();
	
}

 @DeleteMapping("payment/{id}")
	public void deletePaymentById(@PathVariable("id") Integer id) throws PaymentException {
		
		  this.paymentService.deletePaymentById(id);
		
		
		 
		}



}
