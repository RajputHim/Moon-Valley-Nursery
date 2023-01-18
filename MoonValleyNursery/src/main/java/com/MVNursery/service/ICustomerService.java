package com.MVNursery.service;

import com.MVNursery.exception.CustomerException;
import com.MVNursery.model.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer getCustomerById(Integer customerId)throws CustomerException;
	
	public Customer deleteCustomerById(Integer customerId)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
}
