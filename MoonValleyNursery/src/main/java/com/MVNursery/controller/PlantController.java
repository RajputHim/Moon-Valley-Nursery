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
	
	@PutMapping(value="")
	public ResponseEntity<Plant> updatePlantHandler(@Valid @RequestBody Plant plant){
		Plant updatePlant = pService.addPlant(plant);
		return new ResponseEntity<Plant>(updatePlant, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Plant> deletePlantHandler(@PathVariable Integer id){
		Plant deletePlant = pService.deletePlant(id);
		return new ResponseEntity<Plant>(deletePlant,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Plant> viewPlantByIdHandler(@PathVariable Integer id){
		Plant viewPlantById = pService.viewPlant(id);
		return new ResponseEntity<Plant>(viewPlantById,HttpStatus.OK);
	}
	
	@GetMapping(value="/name/{commonName}")
	public ResponseEntity<List<Plant>> viewPlantByCommonNameHandler(@PathVariable String commonName){
		List<Plant> viewPlantByCoomonName = pService.viewPlantByName(commonName);
		return new ResponseEntity<List<Plant>>(viewPlantByCoomonName,HttpStatus.OK);
	}
	
	@GetMapping(value="")
	public ResponseEntity<List<Plant>> viewAllPlantHandler(){
		List<Plant> allPlant = pService.viewAllPlants();
		return new ResponseEntity<List<Plant>>(allPlant,HttpStatus.OK);
	}
	
	@GetMapping(value="/type/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlantByTypeOfPlantHandler(@PathVariable String typeOfPlant){
		List<Plant> viewPlantByType = pService.viewAllPlants(typeOfPlant);
		return new ResponseEntity<List<Plant>>(viewPlantByType,HttpStatus.OK);
	}
}
