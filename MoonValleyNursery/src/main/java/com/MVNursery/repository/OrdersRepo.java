package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
