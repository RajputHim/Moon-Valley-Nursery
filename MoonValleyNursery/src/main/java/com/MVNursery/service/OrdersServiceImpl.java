package com.MVNursery.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
		
		orders.setOrderDate(LocalDateTime.now());
		
		Orders saveOrder = ordersRepo.save(orders);
		
		if(saveOrder == null) {
			throw new OrdersException("Add product to the Order first...");
		}	

		else {
			return saveOrder;
		}
		
	}

	@Override
	public List<Orders> viewAllOrders() throws OrdersException {
		
		List<Orders> orders = ordersRepo.findAll();
		
		if(orders.isEmpty())
			throw new OrdersException("No Record Found...");
		
		return orders;
		
	}

	@Override
	public Orders viewOrderById(Integer id) throws OrdersException {

		return ordersRepo.findById(id).orElseThrow(()-> new OrdersException("Order Not found with id : "+id));

	}

	@Override
	public Orders deleteOrdrerById(Integer id) throws OrdersException {
		
		Optional<Orders> opt = ordersRepo.findById(id);
		
		if(opt.isPresent()) {
		
			Orders o = opt.get();
			ordersRepo.delete(o);
			return o;
			
		}
		else
			throw new OrdersException("Order Not found with id : "+id);
	
	}

	@Override
	public Orders updateOrder(Orders orders) throws OrdersException {
		
		Optional<Orders> opt = ordersRepo.findById(orders.getBookingOrderId());
		
		if(opt.isPresent()) {
		
			Orders o = ordersRepo.save(orders);

			return o;
			
		}
		else
			throw new OrdersException("Order Not found with id : "+orders.getBookingOrderId());
		
	}	
		
}
