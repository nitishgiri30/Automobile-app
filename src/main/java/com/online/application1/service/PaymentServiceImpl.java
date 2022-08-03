package com.online.application1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.application1.dao.PaymentRepository;
import com.online.application1.dto.Payment;
import com.online.application1.exception.PaymentException;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepository paymentRepo;

	@Override
	public Payment addPayment(Payment paymentObj) throws PaymentException { 
		if(paymentObj == null) 
		{
			throw new PaymentException("Oops you are passing a null Object");
		}  
		else {
		Optional<Payment> payment = this.paymentRepo.findById(paymentObj.getPaymentId());
		if (payment.isPresent()) {
			
			throw new PaymentException("Given paymentId : " + paymentObj.getPaymentId() +  "  Already Exists");
		} 
		else {
		return this.paymentRepo.save(paymentObj); 
		} 
		}
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
	
		Optional<Payment> payment = this.paymentRepo.findById(paymentId);
		if (payment.isEmpty()) {
			
			throw new PaymentException("Given paymentId : " + paymentId +  "  Does not Exist");
		} 
		else {
		return payment.get();
		}
		 
		 
	}

	@Override
	public Payment updatePayment(Payment paymentObj) throws PaymentException {
      
		if(paymentObj == null) 
		{
			throw new PaymentException("Oops you are passing a null Object");
		}
		else {
   Optional<Payment> paymentdb= this.paymentRepo.findById(paymentObj.getPaymentId());
		
		if(paymentdb.isEmpty()) {
			throw new PaymentException("id "  +paymentObj.getPaymentId()+ "  doesn't exist ");
		}
		else {
		return this.paymentRepo.save(paymentObj); 
		} 
		}
	}

	@Override
	public void deletePaymentById(Integer paymentId) throws PaymentException {

		   Optional<Payment> payment = this.paymentRepo.findById(paymentId);
			
			if (payment.isEmpty()) {
				
				throw new PaymentException("paymentId" + paymentId + " Does not exist");
			} 
			
			else {
				
				this.paymentRepo.deleteById(paymentId);
				
			}
		
	}

	@Override
	public List<Payment> getAllPayment() throws PaymentException {

		
		return this.paymentRepo.findAll();
	}

}
