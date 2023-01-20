package com.MVNursery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Planter;

@Repository
public interface PlanterRepo extends JpaRepository<Planter, Integer> {

	public List<Planter> findByPlanterShape(String planterShape);

	public List<Planter> findByPlanterCostBetween(Integer minCost, Integer maxCost);

}
