package com.MVNursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.PlantException;
import com.MVNursery.model.Plant;
import com.MVNursery.repository.PlantRepo;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantRepo pRepo;
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		Plant p = pRepo.save(plant);
		if(p==null) {
			throw new PlantException("Please,Add Plant Details");
		}else {
			return p;
		}
		
	}

}
