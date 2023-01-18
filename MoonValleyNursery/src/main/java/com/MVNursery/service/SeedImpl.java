package com.MVNursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Seed;
import com.MVNursery.repository.SeedRepo;
@Service
public class SeedImpl implements SeedService {
@Autowired
private SeedRepo seedrepo;
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		
		Seed addseed =seedrepo.save(seed);
			
			if(addseed!=null) {
				return addseed;
			}
			else {
				throw new SeedException("Input is not Correct");
			}
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed DeleteSeed(Integer seed_id) throws SeedException {
		Seed sd=seedrepo.findBySeedId(seed_id);
		if(sd==null) {
			throw new SeedException("Null Value");
		}else {
			
		 seedrepo.delete(sd);
			
		}
		return sd;
		
	
	}

	@Override
	public Seed viewSeed(Integer seed_id) throws SeedException {
		Seed sd=seedrepo.findBySeedId(seed_id);
		if(sd==null) {
			throw new SeedException("Null Value");
		}else {
			
			return sd;
			
		}
		
	}

	@Override
	public List<Seed> viewAllSeed() throws SeedException {
		List<Seed> allSeed=seedrepo.findAll();
		if(allSeed==null) {
			throw new SeedException("Null Value");
		}else {
			
		}
		return allSeed;
	}

	@Override
	public List<Seed> getSeedBycommonName(String commonName) throws SeedException {
		
		List<Seed> sd=seedrepo.findAll();
		List <Seed> lp=sd.stream().filter(s->s.getSeed_name().equals(commonName)).toList();
		return lp;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seed> getseedByTypeOfSeed(String typeOfSeeds) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

}
