package com.MVNursery.service;

import com.MVNursery.exception.PlanterException;
import com.MVNursery.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter) throws PlanterException;

}
