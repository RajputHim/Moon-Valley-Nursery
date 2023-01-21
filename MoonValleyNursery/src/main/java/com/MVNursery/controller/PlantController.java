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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Plant;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.service.ISessionService;
import com.MVNursery.service.PlantService;

@RestController
@RequestMapping(value="plants")
public class PlantController {

	@Autowired
	private PlantService pService;
	
	@Autowired
	private ISessionService sessionService;
	
	@PostMapping(value="/{adminId}/{sessionKey}")
	public ResponseEntity<Plant> addPlantHandler(@Valid @RequestBody Plant plant,@PathVariable("adminId") Integer adminId,
			@PathVariable("sessionKey") String sessionKey)throws SessionException{
		
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

		Plant savePlant = pService.addPlant(plant);
		return new ResponseEntity<Plant>(savePlant, HttpStatus.CREATED);
		}else {
			throw new SessionException("Please login with the correct credentials");
		}
	}
	
	@PutMapping(value="/{adminId}/{sessionKey}")
	public ResponseEntity<Plant> updatePlantHandler(@Valid @RequestBody Plant plant,@PathVariable("adminId") Integer adminId,
			@PathVariable("sessionKey") String sessionKey)throws SessionException{
		
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

		
		Plant updatePlant = pService.addPlant(plant);
		return new ResponseEntity<Plant>(updatePlant, HttpStatus.ACCEPTED);
		}else {
			throw new SessionException("Please login with the correct credentials");
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Plant> deletePlantHandler(@PathVariable Integer id,@RequestParam("sessionKey") String sessionKey,
			@RequestParam("adminId") Integer adminId)throws SessionException{
		
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {

		Plant deletePlant = pService.deletePlant(id);
		return new ResponseEntity<Plant>(deletePlant,HttpStatus.OK);
		}else {
			throw new SessionException("Please login with the correct credentials");
		}
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
