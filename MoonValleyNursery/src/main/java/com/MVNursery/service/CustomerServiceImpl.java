package com.MVNursery.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.MVNursery.exception.CustomerException;
import com.MVNursery.model.Customer;
import com.MVNursery.repository.CustomerRepo;

public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		return cRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		return cRepo.findById(customerId).orElseThrow(()-> new CustomerException("No Customer found with that Id:-"+customerId));
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerException {
		Customer customer = cRepo.findById(customerId).orElseThrow(()-> new CustomerException("No Customer found with that Id:-"+customerId));
		cRepo.delete(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer = cRepo.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("No Customer found with that Id:-"+customer.getCustomerId()));
		return cRepo.save(customer);
	}

}
