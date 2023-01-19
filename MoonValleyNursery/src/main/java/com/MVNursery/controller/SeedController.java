package com.MVNursery.controller;

import java.util.List;

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

import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Seed;
import com.MVNursery.repository.SeedRepo;
import com.MVNursery.service.SeedService;

@RestController
public class SeedController {
	
	@Autowired
	private SeedService op;
	
	@PostMapping("/seed")
	public ResponseEntity<Seed>addSeed(@RequestBody Seed seed) throws SeedException{
		Seed s=op.addSeed(seed);
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/seed/{id}")
	public ResponseEntity<Seed>DeleteSeed(@PathVariable("id") Integer seed_id) throws SeedException{
		Seed s=op.DeleteSeed(seed_id);
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
		
	}
	
	@GetMapping("/seed/{id}")
	public ResponseEntity<Seed>viewSeed(@PathVariable("id") Integer seed_id) throws SeedException {
		Seed s=op.viewSeed(seed_id);
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
		
	}
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>>viewAllSeed() throws SeedException {
	List<Seed> s=op.viewAllSeed();
		return new ResponseEntity<List<Seed>>(s,HttpStatus.OK);
		
	}
	@GetMapping("/seeds/{cname}")
	public ResponseEntity<List<Seed>>getSeedBycommonName(@PathVariable("cname") String commonName) throws SeedException {
	List<Seed> s=op.getSeedBycommonName(commonName);
		return new ResponseEntity<List<Seed>>(s,HttpStatus.OK);
		
	}
	
	@PutMapping("/seed")
	public ResponseEntity<Seed>updateSeed(@RequestBody Seed seed) throws SeedException {
		Seed s=op.updateSeed(seed);
		return new ResponseEntity<Seed>(s,HttpStatus.OK);
			
		}
	

}
