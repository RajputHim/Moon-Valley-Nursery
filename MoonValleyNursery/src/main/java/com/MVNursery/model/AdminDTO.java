package com.MVNursery.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AdminDTO {

	@NotNull
	@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long")
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
	private String password;

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
	
	
}
