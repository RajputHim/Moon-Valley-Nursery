package com.MVNursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.model.Planter;
import com.MVNursery.service.PlanterService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService pService;

	@PostMapping("/planters")
	public ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter) {
		Planter savedPlanter = pService.addPlanter(planter);

		return new ResponseEntity<>(savedPlanter, HttpStatus.CREATED);
	}

}
