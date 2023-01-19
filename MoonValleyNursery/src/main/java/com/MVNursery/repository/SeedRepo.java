package com.MVNursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVNursery.model.Seed;

@Repository
public interface SeedRepo extends JpaRepository<Seed,Integer> {
	
		public Seed findBySeedId(Integer seed_id);
}
