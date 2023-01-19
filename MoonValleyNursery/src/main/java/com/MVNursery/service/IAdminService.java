package com.MVNursery.service;

import com.MVNursery.exception.AdminException;
import com.MVNursery.model.Admin;
import com.MVNursery.model.AdminDTO;

public interface IAdminService {

	public Admin addAdmin(AdminDTO adminDto)throws AdminException;
	
	public Admin getAdminById(int adminID)throws AdminException;
	
	public Admin deleteAdminById(int adminID)throws AdminException;
	
	public Admin updateAdmin(Admin admin)throws AdminException;
}
