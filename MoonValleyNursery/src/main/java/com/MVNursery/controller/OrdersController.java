package com.MVNursery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.model.Orders;
import com.MVNursery.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrdersHandler(@Valid @RequestBody Orders orders){
		
		Orders saveOrders = ordersService.addOrder(orders);

		return new ResponseEntity<Orders>(saveOrders, HttpStatus.CREATED);
		
	}
	
}
