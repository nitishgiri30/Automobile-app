package com.online.application1.service;

import java.util.List;

import com.online.application1.dto.Admin;
import com.online.application1.exception.AdminException;



public interface AdminService {

	
    Boolean addAdmin(Admin AdminObj) throws AdminException;
	
	Admin getAdminById(Integer AdminId) throws AdminException;
	
	Admin updateAdmin(Admin AdminObj) throws AdminException;
	
	void deleteAdminById(Integer AdminId) throws AdminException;
	
	 List<Admin> getAllAdmin() throws AdminException;
}
