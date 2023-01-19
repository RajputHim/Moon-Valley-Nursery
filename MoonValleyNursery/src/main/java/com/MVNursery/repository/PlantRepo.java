package com.MVNursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Plant;

@Repository
public interface PlantRepo extends JpaRepository<Plant, Integer> {

	Optional<Plant> findByCommonName(String commonName);
}
