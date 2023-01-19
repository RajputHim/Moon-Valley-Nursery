package com.MVNursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.model.Planter;
import com.MVNursery.repository.PlanterRepo;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterRepo pRepo;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterNotFoundException {
		Planter savedPlanter = pRepo.save(planter);
		if (savedPlanter != null) {
			return savedPlanter;
		} else {
			throw new PlanterNotFoundException("Planter not saved..");
		}
	}

	@Override
	public Planter updatePlanter(Integer planterId, Planter planter) throws PlanterNotFoundException {
		Optional<Planter> opt = pRepo.findById(planterId);

		if (opt.isPresent()) {

			return pRepo.save(planter);
		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planterId);
		}
	}

	@Override
	public Planter deletePlanterById(Integer planterId) throws PlanterNotFoundException {
		Optional<Planter> opt = pRepo.findById(planterId);

		Planter existingPlanter = null;
		if (opt.isPresent()) {
			existingPlanter = opt.get();
			pRepo.deleteById(planterId);
			return existingPlanter;
		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planterId);
		}

	}

	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterNotFoundException {
		return pRepo.findById(planterId)
				.orElseThrow(() -> new PlanterNotFoundException("No planter found by id: " + planterId));

	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterNotFoundException {
		List<Planter> allPlanters = pRepo.findByPlanterShape(planterShape);
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No " + planterShape + " planter found");
		}

		return allPlanters;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterNotFoundException {
		List<Planter> allPlanters = pRepo.findAll();
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No planter found..");
		}

		return allPlanters;
	}

	@Override
	public List<Planter> viewAllPlanters(Double minCost, Double maxCost) throws PlanterNotFoundException {
		List<Planter> allPlanters = pRepo.findByPlanterCostBetween(minCost, maxCost);
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No planter found between " + minCost + " " + maxCost + " cost");
		}

		return allPlanters;

	}

}
