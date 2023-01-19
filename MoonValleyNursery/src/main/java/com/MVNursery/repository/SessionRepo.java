package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Session;

@Repository
public interface SessionRepo extends JpaRepository<Session, Integer>{
	
	public Session findBySessionKey(String key);
}
