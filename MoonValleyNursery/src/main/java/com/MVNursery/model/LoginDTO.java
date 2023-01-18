package com.MVNursery.model;

public class LoginDTO {

	private String email;
	
	private String password;
	
	private UserType userType;

	
	
	public LoginDTO(String email, String password, UserType userType) {
		super();
		this.email = email;
		this.password = password;
		this.userType = userType;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
