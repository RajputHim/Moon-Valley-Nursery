package com.MVNursery.service;

import java.util.List;

import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter) throws PlanterNotFoundException;

	public Planter updatePlanter(Integer planterId, Planter planter) throws PlanterNotFoundException;

	public Planter deletePlanterById(Integer planterId) throws PlanterNotFoundException;

	public Planter viewPlanterById(Integer planterId) throws PlanterNotFoundException;

	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterNotFoundException;

	public List<Planter> viewAllPlanters() throws PlanterNotFoundException;

	public List<Planter> viewAllPlanters(Double minCost, Double maxCost) throws PlanterNotFoundException;

}
