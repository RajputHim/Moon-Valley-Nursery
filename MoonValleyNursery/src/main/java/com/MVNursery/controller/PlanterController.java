package com.MVNursery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Planter;
import com.MVNursery.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;

	@PostMapping("/planters")
	public ResponseEntity<Planter> addPlanterHandler(@Valid @RequestBody Planter planter) {
		Planter savedPlanter = planterService.addPlanter(planter);

		return new ResponseEntity<>(savedPlanter, HttpStatus.CREATED);
	}

	@PatchMapping("/planters/seeds/{planterId}/{seedId}")
	public ResponseEntity<Planter> addSeedInPlanterByIdHandler(@PathVariable("planterId") Integer planterId,
			@PathVariable("seedId") Integer seedId) throws PlanterNotFoundException, SeedException {

		Planter updatedPlanter = planterService.addSeedInPlanterById(planterId, seedId);

		return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/planters/plants/{planterId}/{plantId}")
	public ResponseEntity<Planter> addPlantInPlanterByIdHandler(@PathVariable("planterId") Integer planterId,
			@PathVariable("plantId") Integer plantId) throws PlanterNotFoundException, SeedException {

		Planter updatedPlanter = planterService.addPlantInPlanterById(planterId, plantId);

		return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);
	}

	@GetMapping("/planters/id/{planterId}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("planterId") Integer planterId) {
		Planter planter = planterService.viewPlanterById(planterId);

		return new ResponseEntity<>(planter, HttpStatus.OK);
	}

	@GetMapping("/planters/shape/{planterShape}")
	public ResponseEntity<List<Planter>> getPlanterByShapeHandler(@PathVariable("planterShape") String planterShape) {
		List<Planter> planter = planterService.viewPlanterByShape(planterShape);

		return new ResponseEntity<>(planter, HttpStatus.OK);
	}

	@GetMapping("/plantersBetween/{minCost}/{maxCost}")
	public ResponseEntity<List<Planter>> getAllPlantersBetweenHandler(@PathVariable("minCost") Integer minCost,
			@PathVariable("maxCost") Integer maxCost) {
		List<Planter> planter = planterService.viewAllPlanters(minCost, maxCost);

		return new ResponseEntity<>(planter, HttpStatus.OK);
	}

	@PutMapping("/planters")
	public ResponseEntity<Planter> updatePlanterByIdHandler(@Valid @RequestBody Planter planter) {
		Planter updatedPlanter = planterService.updatePlanter(planter);

		return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<Planter> deletePlanterByIdHandler(@PathVariable("planterId") Integer planterId) {
		Planter planter = planterService.deletePlanterById(planterId);

		return new ResponseEntity<>(planter, HttpStatus.ACCEPTED);
	}

	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlantersHandler() {
		List<Planter> allPlanter = planterService.viewAllPlanters();

		return new ResponseEntity<>(allPlanter, HttpStatus.OK);
	}

}
