package com.online.application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.application1.dto.Order;
import com.online.application1.exception.OrderException;
import com.online.application1.service.OrderServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {
	
	
	@Autowired
	OrderServiceImpl orderService;
	
	 @PostMapping("order")
		public Order createOrder(@RequestBody  Order order) throws OrderException {
			
			return this.orderService.addOrder(order);
			
		}
	  
	  @PutMapping("updateOrder")
		public Order updateOrder(@RequestBody  Order order) throws OrderException {
			
			return this.orderService.updateOrder(order);
			
		}
	  
	  @GetMapping("order/{id}")
		public Order getOrderById(@PathVariable("id")  Integer id) throws OrderException {
			
			return this.orderService.getOrderById(id);
			
		}
	  
		@GetMapping("order/all")
		public List<Order> getAllOrders() throws OrderException {
			
			
			return this.orderService.getAllOrder();
			
		}
		
		 @DeleteMapping("order/{id}")
			public void deleteOrderById(@PathVariable("id") Integer id) throws OrderException {
				
				  this.orderService.deleteOrderById(id);
				
				}
		 

}
