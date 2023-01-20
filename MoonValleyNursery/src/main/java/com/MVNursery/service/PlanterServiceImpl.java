package com.MVNursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.PlantException;
import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Plant;
import com.MVNursery.model.Planter;
import com.MVNursery.model.Seed;
import com.MVNursery.repository.PlantRepo;
import com.MVNursery.repository.PlanterRepo;
import com.MVNursery.repository.SeedRepo;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterRepo planterRepo;

	@Autowired
	private SeedRepo seedRepo;

	@Autowired
	private PlantRepo plantRepo;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterNotFoundException {
		Planter savedPlanter = planterRepo.save(planter);
		if (savedPlanter != null) {
			return savedPlanter;
		} else {
			throw new PlanterNotFoundException("Planter not saved..");
		}
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterNotFoundException {
		Optional<Planter> opt = planterRepo.findById(planter.getPlanterId());

		if (opt.isPresent()) {

			return planterRepo.save(planter);
		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planter.getPlanterId());
		}
	}

	@Override
	public Planter deletePlanterById(Integer planterId) throws PlanterNotFoundException {
		Optional<Planter> opt = planterRepo.findById(planterId);

		Planter existingPlanter = null;
		if (opt.isPresent()) {
			existingPlanter = opt.get();
			planterRepo.deleteById(planterId);
			return existingPlanter;
		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planterId);
		}

	}

	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterNotFoundException {
		return planterRepo.findById(planterId)
				.orElseThrow(() -> new PlanterNotFoundException("No planter found by id: " + planterId));

	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterNotFoundException {
		List<Planter> allPlanters = planterRepo.findByPlanterShape(planterShape);
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No " + planterShape + " planter found");
		}

		return allPlanters;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterNotFoundException {
		List<Planter> allPlanters = planterRepo.findAll();
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No planter found..");
		}

		return allPlanters;
	}

	@Override
	public List<Planter> viewAllPlanters(Integer minCost, Integer maxCost) throws PlanterNotFoundException {

		if (minCost >= maxCost) {
			throw new RuntimeException("Minimum Cost cannot be equal or greater than maximum cost");
		}

		List<Planter> allPlanters = planterRepo.findByPlanterCostBetween(minCost, maxCost);
		if (allPlanters.isEmpty()) {
			throw new PlanterNotFoundException("No planter found between " + minCost + " to " + maxCost + " cost");
		}

		return allPlanters;

	}

	@Override
	public Planter addSeedInPlanterById(Integer planterId, Integer seedId)
			throws PlanterNotFoundException, SeedException {
		Optional<Planter> planterOpt = planterRepo.findById(planterId);

		if (planterOpt.isPresent()) {
			Planter planter = planterOpt.get();
			Optional<Seed> seedOpt = seedRepo.findById(seedId);
			if (seedOpt.isPresent()) {
				Seed seed = seedOpt.get();
				planter.getSeeds().add(seed);
				return planterRepo.save(planter);
			} else {
				throw new SeedException("No seed found by id: " + seedId);
			}

		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planterId);
		}

	}

	@Override
	public Planter addPlantInPlanterById(Integer planterId, Integer plantId)
			throws PlanterNotFoundException, PlantException {
		Optional<Planter> planterOpt = planterRepo.findById(planterId);

		if (planterOpt.isPresent()) {
			Planter planter = planterOpt.get();
			Optional<Plant> plantOpt = plantRepo.findById(plantId);
			if (plantOpt.isPresent()) {
				Plant plant = plantOpt.get();
				planter.getPlants().add(plant);
				return planterRepo.save(planter);
			} else {
				throw new PlantException("No plant found by id: " + plantId);
			}

		} else {
			throw new PlanterNotFoundException("No planter found by id: " + planterId);
		}
	}

}
