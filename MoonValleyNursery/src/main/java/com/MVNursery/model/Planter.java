package com.MVNursery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

	@NotNull
//	@Min(value = 1, message = "Planter height should be greater than equal to 1")
	private double planterHeight;

	@NotNull
//	@Min(value = 1, message = "Planter capacity should be greater than equal to 1")
	private Integer planterCapacity;

	@NotNull
//	@Min(value = 1, message = "Drainage holes should be greater than or equal to 1")
	private Integer drainageHoles;

	@NotNull
	private String planterColor;

	@NotNull
	private String planterShape;

	@NotNull
//	@Min(value = 0, message = "Planter stock should be greater than or equal to 0")
	private Integer planterStock;

	@NotNull
//	@Min(value = 0, message = "Planter cost cannot be negative")
	private Integer planterCost;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Plant> plants = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Seed> seeds = new ArrayList<>();

}
