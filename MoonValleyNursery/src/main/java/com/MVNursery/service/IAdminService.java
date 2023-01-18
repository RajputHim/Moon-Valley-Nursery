package com.MVNursery.service;

import com.MVNursery.exception.AdminException;
import com.MVNursery.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin)throws AdminException;
	
	public Admin getAdminById(int adminID)throws AdminException;
	
	public Admin deleteAdminById(int adminID)throws AdminException;
	
	public Admin updateAdmin(Admin admin)throws AdminException;
}
