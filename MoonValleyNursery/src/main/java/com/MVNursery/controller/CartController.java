package com.MVNursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.CartNotFoundException;
import com.MVNursery.exception.CustomerException;
import com.MVNursery.exception.PlanterNotFoundException;
import com.MVNursery.exception.SeedException;
import com.MVNursery.exception.SessionException;
import com.MVNursery.model.ProductCart;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.service.ISessionService;
import com.MVNursery.service.ProductCartService;

@RestController
public class CartController {

	@Autowired
	private ProductCartService cartService;

	@Autowired
	private ISessionService sessionService;

	@PostMapping("/cart/planters/{planterId}")
	public ResponseEntity<ProductCart> addPlanterToCartHandler(@RequestParam("customerId") Integer customerId,
			@RequestParam("sessionKey") String sessionKey, @PathVariable("planterId") Integer planterId)
			throws SessionException, PlanterNotFoundException, CustomerException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == customerId && session.getUserType() == UserType.CUSTOMER) {

			ProductCart updatedCart = cartService.addPlanterToCart(planterId, customerId);

			return new ResponseEntity<ProductCart>(updatedCart, HttpStatus.ACCEPTED);

		} else {
			throw new SessionException("Please login with the correct credentials");
		}
	}

	@PostMapping("/cart/plants/{plantId}")
	public ResponseEntity<ProductCart> addPlantToCartHandler(@RequestParam("customerId") Integer customerId,
			@RequestParam("sessionKey") String sessionKey, @PathVariable("plantId") Integer plantId)
			throws SessionException, CustomerException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == customerId && session.getUserType() == UserType.CUSTOMER) {

			ProductCart updatedCart = cartService.addPlantToCart(plantId, customerId);

			return new ResponseEntity<ProductCart>(updatedCart, HttpStatus.ACCEPTED);

		} else {
			throw new SessionException("Please login with the correct credentials");
		}
	}

	@PostMapping("/cart/seeds/{seedId}")
	public ResponseEntity<ProductCart> addSeedToCartHandler(@RequestParam("customerId") Integer customerId,
			@RequestParam("sessionKey") String sessionKey, @PathVariable("seedId") Integer seedId)
			throws SessionException, CustomerException, SeedException {

		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == customerId && session.getUserType() == UserType.CUSTOMER) {

			ProductCart updatedCart = cartService.addSeedToCart(seedId, customerId);

			return new ResponseEntity<ProductCart>(updatedCart, HttpStatus.ACCEPTED);

		} else {
			throw new SessionException("Please login with the correct credentials");
		}

	}

	@GetMapping("/cart/{cartId}")
	public ResponseEntity<ProductCart> viewCartByIdHandler(@PathVariable("cartId") Integer cartId,
			@RequestParam("customerId") Integer customerId, @RequestParam("sessionKey") String sessionKey)
			throws CartNotFoundException, CustomerException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);

		if (session.getUserId() == customerId && session.getUserType() == UserType.CUSTOMER) {

			ProductCart cart = cartService.viewCartbyId(cartId, customerId);

			return new ResponseEntity<ProductCart>(cart, HttpStatus.ACCEPTED);

		} else {
			throw new SessionException("Please login with the correct credentials");
		}
	}

}
