package com.MVNursery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MVNursery.model.Plant;

public interface PlantRepo {

	Optional<Plant> findByCommonName(String commonName);
}
