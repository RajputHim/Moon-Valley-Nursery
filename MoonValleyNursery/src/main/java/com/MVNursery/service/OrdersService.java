package com.MVNursery.service;

import org.springframework.stereotype.Service;

import com.MVNursery.exception.OrdersException;
import com.MVNursery.model.Orders;


public interface OrdersService {

	public Orders addOrder(Orders orders) throws OrdersException;
	
}
