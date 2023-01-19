package com.MVNursery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/order")
	public ResponseEntity<List<Orders>> viewAllOrdersHandler(){
		
		List<Orders> list = ordersService.viewAllOrders();
		
		return new ResponseEntity<List<Orders>>(list, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Orders> viewOrderHandler(@PathVariable("id") Integer id){
		
		Orders orders = ordersService.viewOrderById(id);
		
		return new ResponseEntity<Orders>(orders, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Orders> deleteOrderHandler(@PathVariable("id") Integer id){
		
		Orders orders = ordersService.deleteOrdrerById(id);
		
		return new ResponseEntity<Orders>(orders, HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/order")
	public ResponseEntity<Orders> updateOrdersHandler( @RequestBody Orders orders){
		
		Orders saveOrders = ordersService.updateOrder(orders);

		return new ResponseEntity<Orders>(saveOrders, HttpStatus.ACCEPTED);
		
	}
	
}
