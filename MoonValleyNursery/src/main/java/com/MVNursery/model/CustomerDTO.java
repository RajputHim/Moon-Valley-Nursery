package com.MVNursery.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerDTO {

	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
	private String password;

	@NotNull
	@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long")
	private String name;

	@NotNull
	private AddressDTO address;

	public ProductCart getCart() {
		return cart;
	}

	public void setCart(ProductCart cart) {
		this.cart = cart;
	}

	@JsonIgnore
	private ProductCart cart = new ProductCart();

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}
