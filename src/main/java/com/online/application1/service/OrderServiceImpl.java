package com.online.application1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.application1.dao.OrderRepository;
import com.online.application1.dto.Order;
import com.online.application1.exception.OrderException;
import com.online.application1.exception.PaymentException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	public Order addOrder(Order orderObj) throws OrderException { 
		if(orderObj == null) 
		{
			throw new OrderException("Oops you are passing a null Object");
		} 
		else {
		Optional<Order> order = this.orderRepo.findById(orderObj.getOrderId());
		if (order.isPresent()) {

			throw new OrderException("Given orderId : " + orderObj.getOrderId() + "  Already Exists");
		} else {
			return this.orderRepo.save(orderObj);
		} 
		}
	}

	@Override
	public Order getOrderById(Integer orderId) throws OrderException {

		Optional<Order> order = this.orderRepo.findById(orderId);
		if (order.isEmpty()) {

			throw new OrderException("Given orderId : " + orderId + "  Does not Exist"); 
		} else {
			return order.get();
		} 

	}

	@Override
	public Order updateOrder(Order orderObj) throws OrderException {
		if(orderObj == null) 
		{
			throw new OrderException("Oops you are passing a null Object");
		}
		else {
		Optional<Order> orderdb = this.orderRepo.findById(orderObj.getOrderId());

		if (orderdb.isEmpty()) {
			throw new OrderException("id " + orderObj.getOrderId() + "  doesn't exist ");
		} else {

			return this.orderRepo.save(orderObj);
		} 
		}
	}

	@Override
	public void deleteOrderById(Integer orderId) throws OrderException {

		Optional<Order> order = this.orderRepo.findById(orderId);

		if (order.isEmpty()) {

			throw new OrderException("orderId" + orderId + " Does not exist");
		}

		else {

			this.orderRepo.deleteById(orderId);

		}

	}

	@Override
	public List<Order> getAllOrder() throws OrderException {

		return this.orderRepo.findAll();
	}

}
