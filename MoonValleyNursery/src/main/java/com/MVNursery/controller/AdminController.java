package com.MVNursery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.AdminException;
import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Admin;
import com.MVNursery.model.AdminDTO;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.service.IAdminService;
import com.MVNursery.service.ISessionService;

@RestController
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private ISessionService sessionService;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody @Valid AdminDTO admin) throws AdminException{
		Admin savedAdmin = adminService.addAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("adminId") Integer adminId, @RequestParam("sessionKey") String sessionKey) throws AdminException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
			Admin admin = adminService.getAdminById(adminId);
			return new ResponseEntity<>(admin, HttpStatus.CREATED);
		}
		throw new SessionException("Please login with the correct credentials");
	}
	
	@DeleteMapping("/admins/{adminId}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable("adminId") Integer adminId, @RequestParam("sessionKey") String sessionKey) throws AdminException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
			Admin admin = adminService.deleteAdminById(adminId);
			return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
		}
		throw new SessionException("Please login with correct credentials");	
	}
	
	@PutMapping("/admins")
	public ResponseEntity<Admin> updateAdmin(@RequestBody @Valid Admin admin, @RequestParam("sessionKey") String sessionKey) throws AdminException, SessionException{
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserId() == admin.getAdminId() && session.getUserType() == UserType.ADMIN) {
			Admin updateAdmin = adminService.updateAdmin(admin);
			return new ResponseEntity<>(updateAdmin, HttpStatus.ACCEPTED);
		}
		throw new SessionException("Please login with correct credentials");
	}
	
}
