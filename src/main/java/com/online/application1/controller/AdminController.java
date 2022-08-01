package com.online.application1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.application1.dto.Admin;
import com.online.application1.exception.AdminException;
import com.online.application1.service.AdminServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AdminController {
	
	@Autowired 
	AdminServiceImpl adminService;
	

	  @PostMapping("admin")
		public String createAdmin(@RequestBody  Admin admin) throws AdminException {
			
			this.adminService.addAdmin(admin);
			
			return "Admin Added Successfully ...";
			
		}
	  
	  @PutMapping("updateAdmin")
		public String updateAdmin(@RequestBody  Admin admin) throws AdminException {
			
			this.adminService.updateAdmin(admin);
			
			return "Admin Updated Successfully ...";
			
		}
	  
	  @GetMapping("admin/{id}")
		public Admin getAdminById(@PathVariable("id")  Integer id) throws AdminException {
			
			return this.adminService.getAdminById(id);
			
		}
	  
		@GetMapping("admin/all")
		public List<Admin> getAllAdmins() throws AdminException {
			
			
			return this.adminService.getAllAdmin();
			
		}
		
		 @DeleteMapping("admin/{id}")
			public String deleteAdminById(@PathVariable("id") Integer id) throws AdminException {
				
				  this.adminService.deleteAdminById(id);
				  
				  return "Admin Deleted Successfully ...";
				
				}

}
