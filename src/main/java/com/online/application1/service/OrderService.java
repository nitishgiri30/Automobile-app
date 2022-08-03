package com.online.application1.service;

import java.util.List;

import com.online.application1.dto.Order;

import com.online.application1.exception.OrderException;

public interface OrderService {
  
	Order addOrder(Order orderObj) throws OrderException;
	
	
	Order getOrderById(Integer orderId) throws OrderException;
	
	Order updateOrder(Order orderObj) throws OrderException;
	
	void deleteOrderById(Integer orderId) throws OrderException;
	
	 List<Order> getAllOrder() throws OrderException;
	 
}
