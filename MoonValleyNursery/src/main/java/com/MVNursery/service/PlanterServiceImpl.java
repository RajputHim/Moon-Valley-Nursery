package com.MVNursery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.PlanterException;
import com.MVNursery.model.Planter;
import com.MVNursery.repository.PlanterRepo;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterRepo pRepo;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		if (planter != null) {
			return pRepo.save(planter);
		} else {
			throw new PlanterException("Invalid Planter details");
		}
	}

}
