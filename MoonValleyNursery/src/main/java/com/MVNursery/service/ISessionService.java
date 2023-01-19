package com.MVNursery.service;

import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Session;

public interface ISessionService {

	public Session getASessionByKey(String key)throws SessionException;
}
