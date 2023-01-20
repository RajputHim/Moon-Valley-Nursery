package com.MVNursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.PlantException;
import com.MVNursery.model.Plant;
import com.MVNursery.repository.PlantRepo;

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
	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		Optional<Plant> opt = pRepo.findById(plant.getPlantId());
		if (opt.isPresent()) {
			return pRepo.save(plant);
		} else {
			throw new PlantException("Not found....");
		}
	}
	@Override
	public Plant deletePlant(Integer id) throws PlantException {
		Plant foundPlant = pRepo.findById(id).orElseThrow(() -> new PlantException("Plant does not exist"));
		pRepo.delete(foundPlant);
		return foundPlant;
	}
	@Override
	public Plant viewPlant(Integer id) throws PlantException {
		Plant foundPlant = pRepo.findById(id).orElseThrow(() -> new PlantException("Plant does not exist"));
		return foundPlant;
		
	}
	@Override
	public List<Plant> viewPlantByName(String commonName) throws PlantException {
		List<Plant> list = pRepo.findByCommonName(commonName);
		if (list.isEmpty()) {
			throw new PlantException("Plant does not exist with this Name");
		} else {
			return list;
		}
	}
	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		List<Plant> plantList = pRepo.findAll();
		if (plantList.isEmpty())
			throw new PlantException("No Plant Found...");
		return plantList;
		
	}
	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException {
		List<Plant> plantList = pRepo.findByTypeOfPlant(typeOfPlant);
		if (plantList.isEmpty())
			throw new PlantException("No Plant Found...");
		return plantList;
		
	}

}
