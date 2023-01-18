package com.MVNursery.model;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingOrderId;
	
	private LocalDate oderDate;
	
	@NotNull(message = "MAndatory")
	private String transactionMode;
	
	@NotNull(message = "MAndatory")
	private Integer quantity;
	
	@NotNull(message = "MAndatory")
	private double totalCost;
	
//	@ManyToOne
//	private Planters planters;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Orders(Integer bookingOrderId, LocalDate oderDate, String transactionMode, Integer quantity,
			double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.oderDate = oderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}



	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public LocalDate getOderDate() {
		return oderDate;
	}

	public void setOderDate(LocalDate oderDate) {
		this.oderDate = oderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

//	public Planters getPlanters() {
//		return planters;
//	}
//
//	public void setPlanters(Planters planters) {
//		this.planters = planters;
//	}

	@Override
	public String toString() {
		return "Orders [bookingOrderId=" + bookingOrderId + ", oderDate=" + oderDate + ", transactionMode="
				+ transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost + "]";
	}
	
	
	
}
