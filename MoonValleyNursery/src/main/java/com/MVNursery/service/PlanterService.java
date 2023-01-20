package com.MVNursery.service;

import java.util.List;

import com.MVNursery.exception.PlantException;
import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter) throws PlanterNotFoundException;

	public Planter updatePlanter(Planter planter) throws PlanterNotFoundException;

	public Planter deletePlanterById(Integer planterId) throws PlanterNotFoundException;

	public Planter viewPlanterById(Integer planterId) throws PlanterNotFoundException;

	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterNotFoundException;

	public List<Planter> viewAllPlanters() throws PlanterNotFoundException;

	public List<Planter> viewAllPlanters(Integer minCost, Integer maxCost) throws PlanterNotFoundException;

	public Planter addSeedInPlanterById(Integer planterId, Integer seedId)
			throws PlanterNotFoundException, SeedException;

	public Planter addPlantInPlanterById(Integer planterId, Integer plantId)
			throws PlanterNotFoundException, PlantException;

}
