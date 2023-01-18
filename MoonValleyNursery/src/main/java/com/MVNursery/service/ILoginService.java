package com.MVNursery.service;

import com.MVNursery.exception.LoginException;
import com.MVNursery.model.LoginDTO;
import com.MVNursery.model.Session;

public interface ILoginService {

	public Session login(LoginDTO loginDto)throws LoginException;
	
	public String logout(Integer userId)throws LoginException;
}
