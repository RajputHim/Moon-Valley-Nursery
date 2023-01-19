package com.MVNursery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.model.Planter;
import com.MVNursery.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService pService;

	@PostMapping("/planters")
	public ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter) {
		Planter savedPlanter = pService.addPlanter(planter);

		return new ResponseEntity<>(savedPlanter, HttpStatus.CREATED);
	}

	@GetMapping("/planters/{planterId}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("planterId") Integer planterId) {
		Planter planter = pService.viewPlanterById(planterId);

		return new ResponseEntity<>(planter, HttpStatus.CREATED);
	}

	@PutMapping("/planters/{planterId}")
	public ResponseEntity<Planter> updatePlanterByIdHandler(@PathVariable("planterId") Integer planterId,
			@Valid @RequestBody Planter planter) {
		Planter updatedPlanter = pService.updatePlanter(planterId, planter);

		return new ResponseEntity<>(updatedPlanter, HttpStatus.CREATED);
	}

	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<Planter> deletePlanterByIdHandler(@PathVariable("planterId") Integer planterId) {
		Planter planter = pService.deletePlanterById(planterId);

		return new ResponseEntity<>(planter, HttpStatus.CREATED);
	}

	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlantersHandler() {
		List<Planter> allPlanter = pService.viewAllPlanters();

		return new ResponseEntity<>(allPlanter, HttpStatus.CREATED);
	}

}
