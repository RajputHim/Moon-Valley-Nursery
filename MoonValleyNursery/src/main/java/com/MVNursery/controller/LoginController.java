package com.MVNursery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.AdminException;
import com.MVNursery.exception.CustomerException;
import com.MVNursery.exception.LoginException;
import com.MVNursery.model.LoginDTO;
import com.MVNursery.model.Session;
import com.MVNursery.service.ILoginService;

@RestController
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Session> login(@RequestBody LoginDTO loginDto) throws LoginException, AdminException, CustomerException{
		Session session = loginService.login(loginDto);
		return new ResponseEntity<>(session, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/logout/{userId}")
	public ResponseEntity<String> logout(@PathVariable("userId") Integer userId)throws LoginException{
		String message = loginService.logout(userId);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}
	
}
