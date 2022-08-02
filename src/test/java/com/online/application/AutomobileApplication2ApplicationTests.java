package com.online.application;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.online.application.dto.Admin;
import com.online.application.exception.AdminException;
import com.online.application.service.AdminService;

@SpringBootTest
class AutomobileApplication2ApplicationTests {

	@Test
	void contextLoads() {
	}
 
	@Autowired
	private AdminService adminService;
	
	
	
	@AfterEach
	public void deleteAdminTest () throws AdminException {
		
	
		adminService.deleteAdminById(4);
		
	assertThat(adminService.isAdminExistById(4)).isFalse();
	}
	
	
	
	
	 /*@Test
     void getAllAdminInformationTest() throws AdminException {
   	 
   	  List<Admin> foundAdmins = adminService.getAllAdmin();
   	  
   	  assertNotNull(foundAdmins);
   	    assertEquals(4, foundAdmins.size());
    }
    
    */
    
	

	/*@Test
	void addAdminTest() throws AdminException {
		Admin addAdmin=new Admin(2,"Manish","Manish@gmail.com");
		assertTrue(this.adminService.addAdmin(addAdmin));
	}
	*/
	
	
	
	
	/*
	 * @Test
	void getAdminByIdTest() throws AdminException {
		
		Admin admin=new Admin(4,"Akash","Akash@gmail.com");
		assertTrue(adminService.addAdmin(admin));
		
		Integer admin2=adminService.getAdminById(3).getId();
		Integer id=admin2;
		assertEquals(id,3);
		
      }
	*/
	
	
	/*@Test
	public void adminUpdateTest () throws AdminException {
		Admin admin = adminService.getAdminById(3);
		admin.setName("Nitish Giri");
	    adminService.updateAdmin(admin);
		assertEquals("Nitish Giri", adminService.getAdminById(3).getName());
	}
	
	*/
	
	
	
	
	
	
	
}
