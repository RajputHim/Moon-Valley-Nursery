package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.ProductCart;

@Repository
public interface ProductCartRepo extends JpaRepository<ProductCart, Integer> {

}
