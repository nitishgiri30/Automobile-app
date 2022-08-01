package com.online.application1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.application1.dto.Customer;
import com.online.application1.exception.CustomerException;
import com.online.application1.service.CustomerServiceImpl;



@RestController

public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@PostMapping("/customer")
	public String createCustomer(@RequestBody  Customer customer) throws CustomerException {
		
		
		this.customerService.addCustomer(customer);
		
		return "Customer Added Successfully ...";
	
		
	}
	
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody  Customer customer) throws CustomerException {
		
		this.customerService.updateCustomer(customer);
		
		return "Customer Updated Successfully ...";
		
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id")  Integer id) throws CustomerException {
		
		return this.customerService.getCustomerById(id);
		
	}
	
	@GetMapping("/customer/all")
	public List<Customer> getAllCustomers() throws CustomerException {
		
		
		return this.customerService.getAllCustomer();
		
	}
	
	  @DeleteMapping("/customer/{id}")
		public String deleteCustomerById(@PathVariable("id") Integer id) throws CustomerException {
			
			  this.customerService.deleteCustomerById(id);
			  
			  return "Customer Deleted Successfully ...";
			   
			}
	  
	  @GetMapping("/countCustomers")
	   public long countCustomer() throws CustomerException{
		   return this.customerService.countCustomers();
		   
		   
	   }

}
