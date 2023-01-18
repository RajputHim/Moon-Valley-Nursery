package com.MVNursery.service;

import com.MVNursery.exception.PlantException;
import com.MVNursery.model.Plant;

public interface PlantService {

	public Plant addPlant(Plant plant) throws PlantException;

	public Plant updatePlant(Plant plant) throws PlantException;

	public Plant deletePlant(Integer id) throws PlantException;

	public Plant viewPlant(Integer id) throws PlantException;

	public Plant viewPlant(String commonName) throws PlantException;

	public java.util.List<Plant> viewAllPlants() throws PlantException;

	public java.util.List<Plant> viewAllPlants(String typeOfPlant) throws PlantException;
}
