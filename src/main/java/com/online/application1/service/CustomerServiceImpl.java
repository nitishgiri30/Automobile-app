package com.online.application1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.application1.dao.CustomerRepository;
import com.online.application1.dto.Customer;
import com.online.application1.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Boolean addCustomer(Customer customerObj) throws CustomerException {
		
		   if(customerObj == null) {
			return false;
		   }
		   
		Boolean success = false;
		Optional<Customer> customer2 = this.customerRepo.findById(customerObj.getUserId());
		
		if (customer2.isPresent()) {
			
			throw new CustomerException("Given CustomerId :" + customerObj.getUserId() + " already Exists try Another CustomerId");
		} 
		
		else {
			
			this.customerRepo.save(customerObj);
			success = true;
		}
		return success;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {

		

	 	Optional<Customer> customer = this.customerRepo.findById(customerId);
		if (customer.isEmpty()) {
			
			throw new CustomerException("Given customerId : " + customerId +  "  Does not Exist");
		}
		return customer.get();
	 
		 
		 }
	

	@Override
	public Customer updateCustomer(Customer customerObj) throws CustomerException {
   
		Optional<Customer> customerdb= this.customerRepo.findById(customerObj.getUserId());
		
		if(customerdb.isEmpty()) {
			throw new CustomerException("id "  +customerObj.getUserId()+ "  doesn't exist ");
		}
	
		
		
		return this.customerRepo.save(customerObj);
	}

	@Override
	public void deleteCustomerById(Integer customerId) throws CustomerException {
		
		
      Optional<Customer> customer = this.customerRepo.findById(customerId);
		
		if (customer.isEmpty()) {
			
			throw new CustomerException("customerId" + customerId + " Does not exist");
		} 
		
		else {
			
			this.customerRepo.deleteById(customerId);
			
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
         
		return this.customerRepo.findAll();
		
	}
	
	@Override
	public long countCustomers () throws CustomerException{
		return customerRepo.count();
	}

	
}
