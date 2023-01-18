package com.MVNursery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MVNursery.exception.OrdersException;
import com.MVNursery.model.Orders;


public interface OrdersService {

	public Orders addOrder(Orders orders) throws OrdersException;
	
	public List<Orders> viewAllOrders()throws OrdersException;
	
	public Orders viewOrderById(Integer id)throws OrdersException;
	
	public Orders deleteOrdrerById(Integer id)throws OrdersException;
	
}
