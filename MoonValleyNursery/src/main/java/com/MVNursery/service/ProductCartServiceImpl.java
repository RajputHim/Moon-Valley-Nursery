package com.MVNursery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.CartNotFoundException;
import com.MVNursery.exception.CustomerException;
import com.MVNursery.exception.PlantException;
import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.model.Customer;
import com.MVNursery.model.Plant;
import com.MVNursery.model.Planter;
import com.MVNursery.model.ProductCart;
import com.MVNursery.model.Seed;
import com.MVNursery.repository.PlantRepo;
import com.MVNursery.repository.PlanterRepo;
import com.MVNursery.repository.ProductCartRepo;
import com.MVNursery.repository.SeedRepo;

@Service
public class ProductCartServiceImpl implements ProductCartService {

	@Autowired
	private ProductCartRepo cartRepo;

	@Autowired
	private PlanterRepo planterRepo;

	@Autowired
	private PlantRepo plantRepo;

	@Autowired
	private SeedRepo seedRepo;

	@Autowired
	private ICustomerService customerService;

	@Override
	public ProductCart addPlanterToCart(Integer planterId, Integer customerId)
			throws PlanterNotFoundException, CustomerException {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {

			Optional<Planter> planterOpt = planterRepo.findById(planterId);

			if (planterOpt.isPresent()) {
				ProductCart pCart = customer.getCart();

				pCart.getPlanters().add(planterOpt.get());

				return cartRepo.save(pCart);

			} else {
				throw new PlanterNotFoundException("No planter found by id: " + planterId);
			}

		} else {
			throw new CartNotFoundException("No customer found by id:" + customerId);
		}

	}

	@Override
	public ProductCart addPlantToCart(Integer plantId, Integer customerId) throws PlantException, CustomerException {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {

			Optional<Plant> plantOpt = plantRepo.findById(plantId);

			if (plantOpt.isPresent()) {
				ProductCart pCart = customer.getCart();

				pCart.getPlants().add(plantOpt.get());

				return cartRepo.save(pCart);

			} else {
				throw new PlantException("No plant found by id: " + plantId);
			}

		} else {
			throw new CartNotFoundException("No customer found by id:" + customerId);
		}

	}

	@Override
	public ProductCart addSeedToCart(Integer seedId, Integer customerId) throws SeedException, CustomerException {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {

			Optional<Seed> seedOpt = seedRepo.findById(seedId);

			if (seedOpt.isPresent()) {
				ProductCart pCart = customer.getCart();

				pCart.getSeeds().add(seedOpt.get());

				return cartRepo.save(pCart);

			} else {
				throw new SeedException("No seed found by id: " + seedId);
			}

		} else {
			throw new CartNotFoundException("No customer found by id:" + customerId);
		}
	}

	@Override
	public ProductCart viewCartbyId(Integer cartId, Integer customerId)
			throws CartNotFoundException, CustomerException {
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {

			return cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException());

		} else {
			throw new CartNotFoundException("No customer found by id:" + customerId);
		}
	}

}
