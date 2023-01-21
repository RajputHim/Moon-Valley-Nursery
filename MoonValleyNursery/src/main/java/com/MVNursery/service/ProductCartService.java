package com.MVNursery.service;

import com.MVNursery.exception.CartNotFoundException;
import com.MVNursery.exception.CustomerException;
import com.MVNursery.exception.PlantException;
import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.ProductCart;

public interface ProductCartService {

	public ProductCart addPlanterToCart(Integer planterId, Integer customerId)
			throws PlanterNotFoundException, CustomerException;

	public ProductCart addPlantToCart(Integer plantId, Integer customerId) throws PlantException, CustomerException;

	public ProductCart addSeedToCart(Integer seedId, Integer customerId) throws SeedException, CustomerException;

	public ProductCart viewCartbyId(Integer cartId, Integer customerId) throws CartNotFoundException, CustomerException;

}
