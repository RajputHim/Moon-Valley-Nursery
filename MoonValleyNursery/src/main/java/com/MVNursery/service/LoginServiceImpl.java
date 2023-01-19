package com.MVNursery.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.AdminException;
import com.MVNursery.exception.CustomerException;
import com.MVNursery.exception.LoginException;
import com.MVNursery.model.Admin;
import com.MVNursery.model.Customer;
import com.MVNursery.model.LoginDTO;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.repository.AdminRepo;
import com.MVNursery.repository.CustomerRepo;
import com.MVNursery.repository.SessionRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	private SessionRepo sRepo;
	
	@Autowired
	private AdminRepo aRepo;
	
	@Autowired 
	private CustomerRepo cRepo;

	@Override
	public Session login(LoginDTO loginDto) throws LoginException, AdminException, CustomerException {
		Session session = null;
		if(!sRepo.findAll().isEmpty())
			throw new LoginException("User is already logged in. Please logout first and then try to login");
		
		if(loginDto.getUserType() == UserType.ADMIN) {
			Admin admin = aRepo.findByEmail(loginDto.getEmail());
			if(admin == null)
				throw new AdminException("No Admin found with that email:-"+loginDto.getEmail());
			
			if(!admin.getPassword().equals(loginDto.getPassword()))
				throw new LoginException("The email and password combination seems incorrect. Please try again");
			
			String key = RandomString.make(6);
			
			Session adminSession = new Session();
			adminSession.setSessionKey(key);
			adminSession.setTimeStamp(LocalDateTime.now());
			adminSession.setUserId(admin.getAdminId());
			adminSession.setUserType(UserType.ADMIN);
			session = sRepo.save(adminSession);
		}
		else {
			Customer customer = cRepo.findByEmail(loginDto.getEmail());
			if(customer == null)
				throw new CustomerException("No Customer found with that email:-"+loginDto.getEmail());
			
			if(!customer.getPassword().equals(loginDto.getEmail()))
				throw new LoginException("The email and password combination seems incorrect. Please try again");
			
			String key = RandomString.make(6);

			Session customerSession = new Session();
			customerSession.setSessionKey(key);
			customerSession.setTimeStamp(LocalDateTime.now());
			customerSession.setUserId(customer.getCustomerId());
			customerSession.setUserType(UserType.CUSTOMER);
			session = sRepo.save(customerSession);
		}
		return session;
	}

	@Override
	public String logout(Integer userId) throws LoginException {

		Session session = sRepo.findById(userId).orElseThrow(()-> new LoginException("No user is logged in with that userId:-"+userId));
		sRepo.delete(session);
		return "User logged out successfully";
	}

}
