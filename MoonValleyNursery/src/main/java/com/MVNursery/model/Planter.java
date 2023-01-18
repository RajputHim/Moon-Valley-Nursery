package com.MVNursery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	private double planterHeight;
	private Integer planterCapacity;
	private Integer planterStock;
	private Integer planterCost;

}
