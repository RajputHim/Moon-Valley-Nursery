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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MVNursery.exception.SessionException;
import com.MVNursery.model.Orders;
import com.MVNursery.model.Session;
import com.MVNursery.model.UserType;
import com.MVNursery.service.ISessionService;
import com.MVNursery.service.OrdersService;

@RestController
@RequestMapping(value="orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ISessionService sessionService;
	
	@PostMapping(value="/{adminId}/{sessionKey}")
	public ResponseEntity<Orders> addOrdersHandler(@Valid @RequestBody Orders orders,@PathVariable("adminId") Integer adminId,			
			@PathVariable("sessionKey") String sessionKey) throws SessionException{
		
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
		
		Orders saveOrders = ordersService.addOrder(orders);
		
		return new ResponseEntity<Orders>(saveOrders, HttpStatus.CREATED);
		
		}
		else {
			throw new SessionException("Please login with the correct credentials");
		}
	}
	
	@GetMapping(value = "")
	public ResponseEntity<List<Orders>> viewAllOrdersHandler(){
		
		List<Orders> list = ordersService.viewAllOrders();
		
		return new ResponseEntity<List<Orders>>(list, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Orders> viewOrderHandler(@PathVariable("id") Integer id){
		
		Orders orders = ordersService.viewOrderById(id);
		
		return new ResponseEntity<Orders>(orders, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Orders> deleteOrderHandler(@PathVariable("id") Integer id,
			@RequestParam("adminId") Integer adminId,@RequestParam("sessionKey") String sessionKey) throws SessionException{
		
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
		
			Orders orders = ordersService.deleteOrdrerById(id);
			
			return new ResponseEntity<Orders>(orders, HttpStatus.ACCEPTED);
			
		}
		else {
			throw new SessionException("Please login with the correct credentials");
		}
		
	}
	
	@PutMapping(value="/{adminId}/{sessionKey}")
	public ResponseEntity<Orders> updateOrdersHandler( @RequestBody Orders orders,
			@PathVariable("adminId") Integer adminId,@PathVariable("sessionKey") String sessionKey) throws SessionException {

		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserId() == adminId && session.getUserType() == UserType.ADMIN) {
		
			Orders saveOrders = ordersService.updateOrder(orders);

			return new ResponseEntity<Orders>(saveOrders, HttpStatus.ACCEPTED);
			
		}
		else {
			throw new SessionException("Please login with the correct credentials");
		}
			
		
	}
	
}
