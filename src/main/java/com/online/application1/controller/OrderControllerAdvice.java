package com.online.application1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.online.application1.exception.OrderException;

public class OrderControllerAdvice {
	@ExceptionHandler(OrderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderException(OrderException e)
	{
		return e.getMessage();
	}
}
