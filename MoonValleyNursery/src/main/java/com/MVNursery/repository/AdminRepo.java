package com.MVNursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByEmail(String email);
}
