package com.MVNursery.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull
	@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long")
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

	public Customer() {
		super();
	}

	public Customer(
			@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long") String name,
			@Email String email,
			@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long") String password,
			Address address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	

	public Customer(
			@NotNull @Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long") String name,
			@NotNull @Email String email,
			@NotNull @Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + "]";
	}
	
	
}
