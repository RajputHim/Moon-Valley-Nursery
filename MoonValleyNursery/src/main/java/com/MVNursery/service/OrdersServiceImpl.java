package com.MVNursery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.OrdersException;
import com.MVNursery.model.Orders;
import com.MVNursery.repository.OrdersRepo;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepo ordersRepo;

	@Override
	public Orders addOrder(Orders orders) throws OrdersException {
		
		Orders saveOrder = ordersRepo.save(orders);
		
		saveOrder.setOrderDate(LocalDateTime.now());
		
		if(saveOrder == null)
			throw new OrdersException("Add product to the Order first...");

		return saveOrder;
	}
	
}
