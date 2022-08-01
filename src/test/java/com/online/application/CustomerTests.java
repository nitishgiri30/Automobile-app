package com.online.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.online.application1.dao.CustomerRepository;
import com.online.application1.dto.Customer;
import com.online.application1.exception.CustomerException;
import com.online.application1.service.CustomerServiceImpl;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerTests {
	

	@Autowired
	private CustomerRepository customerRepo;
	
	//@Autowired
	//CustomerServiceImpl customerService;
	

	
	

	
	@Test
   public void addCustomerTest() throws CustomerException{
	   
	   System.out.println("....addCustomerTest...");
	   
		
		 Customer customer=new Customer();
  
	  // = new Customer();
		customer.setUserId(1);
		customer.setUserName("nitish");
		customer.setContactNo("9958270471");
		customer.setEmail("nitish@gmail.com");
		customer.setHouseNo(101);
		customer.setStreet("crossing");
		customer.setCity("delhi");
		customer.setState("delhi");
		customer.setPincode(201);
		customer.setCart(null);
		customer.setOrders(null);
		
		customerRepo.save(customer);
		
		assertNotNull(customerRepo.findById(1).get());
	   //  assertEquals(1, fetchedCustomer.getUserId());
	   
	


	
	   
	}

}
