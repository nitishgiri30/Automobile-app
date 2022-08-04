package com.online.application1.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.application1.dto.Order;
import com.online.application1.dto.Product;
import com.online.application1.exception.OrderException;
import com.online.application1.service.OrderService;



@SpringBootTest 
@TestMethodOrder(MethodOrderer.DisplayName.class)
class OrderServiceTest {

	@Autowired 
	private OrderService orderService; 
	
	
	@Test    
	@DisplayName("1")
	void addOrderTest() throws OrderException { 
		assertTrue(orderService != null);  
		assertThrows(OrderException.class ,()-> this.orderService.addOrder(null));
		Order order = new Order();
		order.setOrderId(2);
		order.setOrderStatus("Pending"); 
		order.setOrderDate(Date.valueOf(LocalDate.now())); 
		order.setPayment(null);
		order.setProducts(null);
	    assertTrue(this.orderService.addOrder(order).getOrderId()==2); 	 
	    assertThrows(OrderException.class ,()-> this.orderService.addOrder(order));
	}
    
	@Test 
	@DisplayName("2")
	void getOrderByIdTest() throws OrderException {
		assertTrue(orderService != null);  
		assertEquals(this.orderService.getOrderById(2).getOrderId(),2);
	}  
	
	@Test 
	@DisplayName("3")
	void updateOrderTest() throws OrderException {
		assertTrue(orderService != null);   
		assertThrows(OrderException.class ,()-> this.orderService.updateOrder(null));
		Order order = new Order(2,"failed",Date.valueOf(LocalDate.now()),null,null);
		assertEquals(this.orderService.updateOrder(order).getOrderStatus(),"failed");  
		Order order1 = new Order();
		order1.setOrderId(order.getOrderId()+1);
		order1.setOrderStatus(order.getOrderStatus()); 
		order1.setOrderDate(order.getOrderDate()); 
		order1.setPayment(order.getPayment());
		order1.setProducts(order.getProducts());
		assertThrows(OrderException.class ,()-> this.orderService.updateOrder(order1));
	} 
	
	@Test 
	@DisplayName("4")
	void getAllOrderTest() throws OrderException { 
		assertTrue(orderService != null);  
		List<Order> orderList = this.orderService.getAllOrder(); 
		assertEquals(1,orderList.size());
		
	}
	
    @Test 
	@DisplayName("5")
	void deleteOrderByIdTest() throws OrderException {
		assertTrue(orderService != null);     
		this.orderService.deleteOrderById(2); 
		assertThrows(OrderException.class ,()-> this.orderService.deleteOrderById(3));
		assertThrows(OrderException.class ,()-> this.orderService.getOrderById(2)); 
	}  

}
