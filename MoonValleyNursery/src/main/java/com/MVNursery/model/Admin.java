package com.MVNursery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@NotNull
	@Size(min = 3, max = 15, message = "Name should be minimum 3 and maximum 15 characters long")
	private String name;

	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(@Email String email,
			@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
}
