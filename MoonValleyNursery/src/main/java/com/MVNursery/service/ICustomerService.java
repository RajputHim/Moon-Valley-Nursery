package com.MVNursery.service;

import java.util.List;

import com.MVNursery.exception.CustomerException;
import com.MVNursery.model.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer getCustomerById(Integer customerId)throws CustomerException;
	
	public Customer deleteCustomerById(Integer customerId)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public List<Customer> getAllCustomers()throws CustomerException;
}
