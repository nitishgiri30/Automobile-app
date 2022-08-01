package com.online.application1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.online.application1.exception.AdminException;



@RestControllerAdvice
public class AdminControllerAdvice {
	
	@ExceptionHandler(AdminException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	
	
	public String handleAdminException(AdminException e) {
		return e.getMessage();
	}


}
