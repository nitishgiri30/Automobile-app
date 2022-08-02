package com.online.application1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.application1.dao.AdminRepository;
import com.online.application1.dto.Admin;
import com.online.application1.exception.AdminException;


@Service
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Boolean addAdmin(Admin AdminObj) throws AdminException {
		
		
		   if(AdminObj == null) {
			return false;
		   }
		   
		Boolean success = false;
		Optional<Admin> admin2 = this.adminRepo.findById(AdminObj.getId());
		
		if (admin2.isPresent()) {
			
			throw new AdminException("Given AdminId :" + AdminObj.getId() + " already Exists try Another AdminId");
		} 
		
		else {
			
			this.adminRepo.save(AdminObj);
			success = true;
		}
		return success;
	}

	@Override
	public Admin getAdminById(Integer AdminId) throws AdminException {

		Optional<Admin> admin = this.adminRepo.findById(AdminId);
		if (admin.isEmpty()) {
			
			throw new AdminException("Given AdminId : " + AdminId +  "  Does not Exist");
		}
		return admin.get();
	 
		 
		 }
	

	@Override
	public Admin updateAdmin(Admin AdminObj) throws AdminException {

      Optional<Admin> admindb= this.adminRepo.findById(AdminObj.getId());
		
		if(admindb.isEmpty()) {
			throw new AdminException("id "  +AdminObj.getId()+ "  doesn't exist ");
		}
	
		
		
		return this.adminRepo.save(AdminObj);
	}

	@Override
	public void deleteAdminById(Integer AdminId) throws AdminException {

		   Optional<Admin> admin = this.adminRepo.findById(AdminId);
			
			if (admin.isEmpty()) {
				
				throw new AdminException("adminId" + AdminId + " Does not exist");
			} 
			
			else {
				
				this.adminRepo.deleteById(AdminId);
				
			}
		
	}

	@Override
	public List<Admin> getAllAdmin() throws AdminException {

		return this.adminRepo.findAll();
	}

	
	
}
