package com.MVNursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MVNursery.model.Plant;

public interface PlantRepo extends JpaRepository<Plant, Integer> {

	Optional<Plant> findByCommonName(String commonName);
}
