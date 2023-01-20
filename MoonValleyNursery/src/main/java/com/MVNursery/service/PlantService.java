package com.MVNursery.service;

import java.util.List;

import com.MVNursery.exception.PlantException;
import com.MVNursery.model.Plant;

public interface PlantService {

	public Plant addPlant(Plant plant) throws PlantException;

	public Plant updatePlant(Plant plant) throws PlantException;

	public Plant deletePlant(Integer id) throws PlantException;

	public Plant viewPlant(Integer id) throws PlantException;

	public List<Plant> viewPlantByName(String commonName) throws PlantException;

	public List<Plant>  viewAllPlants() throws PlantException;

	public List<Plant> viewAllPlants(String typeOFPlant) throws PlantException;
}
