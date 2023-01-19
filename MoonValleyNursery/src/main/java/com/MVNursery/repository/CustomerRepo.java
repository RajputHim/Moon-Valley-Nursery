package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
}
