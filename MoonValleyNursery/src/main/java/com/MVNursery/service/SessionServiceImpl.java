package com.MVNursery.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Session;
import com.MVNursery.repository.SessionRepo;

public class SessionServiceImpl implements ISessionService{

	@Autowired
	private SessionRepo sRepo;
	
	@Override
	public Session getASessionByKey(String key) throws SessionException {
		Session currentSession = sRepo.findBySessionKey(key);
		if(currentSession == null)
			throw new SessionException("No session fouund with that session key");
		
		return currentSession;
	}

}
