package com.MVNursery.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressDTO {
	
	@NotNull
	@NotBlank
	private String houseNo;
	
	@NotNull
	@NotBlank
	private String colony;
	
	@NotNull
	@NotBlank
	private String city;
	
	@NotNull
	@NotBlank
	private String state;
	
	@NotNull
	@NotBlank
	private Integer pinCode;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
}
