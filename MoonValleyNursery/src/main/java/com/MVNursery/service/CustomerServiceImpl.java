package com.MVNursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVNursery.exception.CustomerException;
import com.MVNursery.model.Address;
import com.MVNursery.model.Customer;
import com.MVNursery.model.CustomerDTO;
import com.MVNursery.repository.AddressRepo;
import com.MVNursery.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private AddressRepo aRepo;
	
	@Override
	public Customer addCustomer(CustomerDTO customerDto) throws CustomerException {
		if(cRepo.findByEmail(customerDto.getEmail()) != null)
			throw new CustomerException("Customer already exists with the email:- "+customerDto.getEmail());
		
		Customer customer = new Customer(customerDto.getName(), customerDto.getEmail(), customerDto.getPassword());
		Address address = new Address(customerDto.getAddress().getHouseNo(), customerDto.getAddress().getColony(), customerDto.getAddress().getCity(), customerDto.getAddress().getState(), customerDto.getAddress().getPinCode(), customer);
		customer.setAddress(address);
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

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List<Customer> customers = cRepo.findAll();
		if(customers.isEmpty())
			throw new CustomerException("No Customer found");
		return customers;
	}

}
