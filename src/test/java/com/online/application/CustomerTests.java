package com.online.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online.application.dto.Customer;
import com.online.application.exception.CustomerException;
import com.online.application.service.CustomerService;

@SpringBootTest
public class CustomerTests {
	
	@Test
	void contextLoads() {
	}
 
	@Autowired
	private CustomerService customerService;
	
	
  /*	@AfterEach
	public void deleteCustomerTest () throws CustomerException {
		
	
		customerService.deleteCustomerById(2);
		
	assertThat(customerService.isCustomerExistById(3)).isFalse();
	}
	
	*/
	
	
  /*	@Test
	void addCustomerTest() throws CustomerException {
		Customer addCustomer=new Customer(1,"Nitish","9958270471","nitish@gmail.com",101,"crossing","delhi","delhi",201009,null,null);
		assertTrue(this.customerService.addCustomer(addCustomer));
	}
	
	*/
	

	/* @Test
	void getCustomerByIdTest() throws CustomerException {
		
		//Customer customer=new Customer(1,"Nitish","9958270471","nitish@gmail.com",101,"crossing","delhi","delhi",201009,null,null);
		//assertTrue(customerService.addCustomer(customer));
		
		Integer customer2=customerService.getCustomerById(1).getUserId();
		Integer id=customer2;
		assertEquals(id,1);
		
      }
      */
	
	/*@Test
	public void customerUpdateTest () throws CustomerException {
		
		Customer customer = customerService.getCustomerById(1);
		customer.setUserName("Nitish Giri");
	    customerService.updateCustomer(customer);
	    
		assertEquals("Nitish Giri", customerService.getCustomerById(1).getUserName());
	}
	
	*/
	

	/* @Test
     void getAllCustomerInformationTest() throws CustomerException {
   	 
   	  List<Customer> foundCustomer = customerService.getAllCustomer();
   	  
   	  assertNotNull(foundCustomer);
   	    assertEquals(2, foundCustomer.size());
    }
    
    */
    
    
	 @Test
    void countAllCustomersTest() throws CustomerException {
  	 
  	  Long foundCustomer = customerService.countCustomers();
  	  
  	    assertNotNull(foundCustomer);
  	    assertEquals(1, foundCustomer);
   }
   
   
	
	

}
