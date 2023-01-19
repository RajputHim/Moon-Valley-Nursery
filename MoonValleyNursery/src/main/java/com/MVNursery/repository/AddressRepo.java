package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MVNursery.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
