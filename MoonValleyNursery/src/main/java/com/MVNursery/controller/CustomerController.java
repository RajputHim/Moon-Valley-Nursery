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

import com.MVNursery.exception.CustomerException;
import com.MVNursery.model.Customer;
import com.MVNursery.model.CustomerDTO;
import com.MVNursery.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	private ICustomerService custService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid CustomerDTO customer) throws CustomerException{
		Customer addedCustomer = custService.addCustomer(customer);
		return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);		
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer customer = custService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerException{
		Customer customer = custService.deleteCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer) throws CustomerException{
		Customer updatedCustomer = custService.updateCustomer(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException{
		return new ResponseEntity<>(custService.getAllCustomers(), HttpStatus.ACCEPTED);
	}
}

















