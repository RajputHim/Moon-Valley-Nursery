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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Planter;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.service.ISessionService;
import com.MVNursery.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;

	@Autowired
	private ISessionService sessionService;

	@PostMapping("/planters/{customerId}/{sessionKey}")
	public ResponseEntity<Planter> addPlanterHandler(@PathVariable("customerId") Integer customerId,
			@PathVariable("sessionKey") String sessionKey, @Valid @RequestBody Planter planter)
			throws SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == customerId && session.getUserType() == UserType.CUSTOMER) {

			Planter savedPlanter = planterService.addPlanter(planter);

			return new ResponseEntity<>(savedPlanter, HttpStatus.CREATED);
		} else {

			throw new SessionException("Please login with the correct credentials");
		}

	}

	@PatchMapping("/planters/seeds/{planterId}/{seedId}")
	public ResponseEntity<Planter> addSeedInPlanterByIdHandler(@RequestParam("sessionKey") String sessionKey,
			@RequestParam("adminId") Integer adminId, @PathVariable("planterId") Integer planterId,
			@PathVariable("seedId") Integer seedId) throws PlanterNotFoundException, SeedException, SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

			Planter updatedPlanter = planterService.addSeedInPlanterById(planterId, seedId);

			return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);

		} else {

			throw new SessionException("Please login with the correct credentials");
		}
	}

	@PatchMapping("/planters/plants/{planterId}/{plantId}")
	public ResponseEntity<Planter> addPlantInPlanterByIdHandler(@RequestParam("sessionKey") String sessionKey,
			@RequestParam("adminId") Integer adminId, @PathVariable("planterId") Integer planterId,
			@PathVariable("plantId") Integer plantId) throws PlanterNotFoundException, SeedException, SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

			Planter updatedPlanter = planterService.addPlantInPlanterById(planterId, plantId);

			return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);

		} else {

			throw new SessionException("Please login with the correct credentials");
		}
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

	@PutMapping("/planters/{sessionKey}/{adminId}")
	public ResponseEntity<Planter> updatePlanterByIdHandler(@PathVariable("sessionKey") String sessionKey,
			@PathVariable("adminId") Integer adminId, @Valid @RequestBody Planter planter) throws SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

			Planter updatedPlanter = planterService.updatePlanter(planter);

			return new ResponseEntity<>(updatedPlanter, HttpStatus.ACCEPTED);
		} else {

			throw new SessionException("Please login with the correct credentials");
		}
	}

	@DeleteMapping("/planters/{planterId}")
	public ResponseEntity<Planter> deletePlanterByIdHandler(@RequestParam("sessionKey") String sessionKey,
			@RequestParam("adminId") Integer adminId, @PathVariable("planterId") Integer planterId)
			throws SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
			Planter planter = planterService.deletePlanterById(planterId);

			return new ResponseEntity<>(planter, HttpStatus.ACCEPTED);
		} else {

			throw new SessionException("Please login with the correct credentials");
		}
	}

	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> getAllPlantersHandler() {
		List<Planter> allPlanter = planterService.viewAllPlanters();

		return new ResponseEntity<>(allPlanter, HttpStatus.OK);
	}

}
