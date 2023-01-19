package com.MVNursery.service;

import java.util.List;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Seed;
public interface SeedService {
	
	public Seed addSeed(Seed seed) throws SeedException;
	
	public Seed updateSeed(Seed seed) throws SeedException;
	
	public Seed DeleteSeed(Integer seed_id) throws SeedException;
	
	public Seed viewSeed(Integer seed_id) throws SeedException;
	
	public List<Seed> viewAllSeed() throws SeedException;
	
	public List<Seed> getSeedBycommonName(String commonName) throws SeedException;
	
	public List<Seed> getseedByTypeOfSeed(String typeOfSeeds) throws SeedException;
}
