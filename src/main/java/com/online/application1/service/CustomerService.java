package com.online.application1.service;

import java.util.List;

import com.online.application1.dto.Customer;
import com.online.application1.exception.CustomerException;

public interface CustomerService {
	
	public Boolean addCustomer(Customer customerObj) throws CustomerException;
	
	Customer getCustomerById(Integer customerId) throws CustomerException;
	
	Customer updateCustomer(Customer customerObj) throws CustomerException;
	
	void deleteCustomerById(Integer customerId) throws CustomerException;
	
	List<Customer> getAllCustomer() throws CustomerException;
	 
    public long countCustomers () throws CustomerException;
	 


}
