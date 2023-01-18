package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Planter;

@Repository
public interface PlanterRepo extends JpaRepository<Planter, Integer> {

}
