package com.MVNursery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.model.Plant;
import com.MVNursery.service.PlantService;

@RestController
@RequestMapping(value="plants")
public class PlantController {

	@Autowired
	private PlantService pService;
	
	@PostMapping(value="")
	public ResponseEntity<Plant> addPlantHandler(@Valid @RequestBody Plant plant){
		Plant savePlant = pService.addPlant(plant);
		return new ResponseEntity<Plant>(savePlant, HttpStatus.CREATED);
	}
	
}
