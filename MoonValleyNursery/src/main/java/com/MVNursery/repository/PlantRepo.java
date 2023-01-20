package com.MVNursery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Plant;


@Repository
public interface PlantRepo extends JpaRepository<Plant, Integer> {

	public List<Plant> findByCommonName(String commonName);
	
	public List<Plant> findByTypeOfPlant(String typeOfPlant);
}
