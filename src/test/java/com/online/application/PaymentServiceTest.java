package com.online.application1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.application1.dto.Order;
import com.online.application1.dto.Payment;
import com.online.application1.exception.OrderException;
import com.online.application1.exception.PaymentException;
import com.online.application1.service.OrderService;
import com.online.application1.service.PaymentService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class PaymentServiceTest {

	@Autowired 
	private PaymentService paymentService;
	
	@Test 
	@DisplayName("1")
	void addPaymentTest() throws  PaymentException { 
		assertTrue(paymentService != null);  
		assertThrows(PaymentException.class ,()-> this.paymentService.addPayment(null));
		Payment payment = new Payment();
		payment.setPaymentId(1);
		payment.setPaymentDate(Date.valueOf(LocalDate.now()));
		payment.setPaymentAmount(7000.0);
		payment.setPaymentStatus("Pending");
		assertTrue(this.paymentService.addPayment(payment).getPaymentId()==1); 
		assertThrows(PaymentException.class ,()-> this.paymentService.addPayment(payment));
	}
    
	@Test 
	@DisplayName("2")
	void getPaymentByIdTest() throws PaymentException {
		assertTrue(paymentService != null); 
		assertTrue(this.paymentService.getPaymentById(1).getPaymentId()==1); 
		
	}  
	
	@Test 
	@DisplayName("3")
	void updatePaymentTest() throws PaymentException {
		assertTrue(paymentService != null);  
		assertThrows(PaymentException.class ,()-> this.paymentService.updatePayment(null));
		Payment payment = new Payment(1,Date.valueOf(LocalDate.now()),7000.0,"failed");
		assertEquals(this.paymentService.updatePayment(payment).getPaymentStatus(),"failed");  
		Payment payment1 = new Payment();
		payment1.setPaymentAmount(payment.getPaymentAmount()); 
		payment1.setPaymentDate(payment.getPaymentDate());
		payment1.setPaymentId(payment.getPaymentId()+1);
		payment1.setPaymentStatus(payment.getPaymentStatus());
		assertThrows(PaymentException.class ,()-> this.paymentService.updatePayment(payment1));
	} 
	
	@Test 
	@DisplayName("5")
	void deletePaymentByIdTest() throws PaymentException {
		assertTrue(paymentService != null);   
		this.paymentService.deletePaymentById(1);
		assertThrows(PaymentException.class ,()-> this.paymentService.getPaymentById(1)); 
		assertThrows(PaymentException.class ,()-> this.paymentService.deletePaymentById(1));
	} 
	
	@Test 
	@DisplayName("4")
	void getAllPaymentTest() throws PaymentException {
		assertTrue(paymentService != null);  
		List<Payment> paymentList = this.paymentService.getAllPayment(); 
		assertEquals(1,paymentList.size());
	} 
}
