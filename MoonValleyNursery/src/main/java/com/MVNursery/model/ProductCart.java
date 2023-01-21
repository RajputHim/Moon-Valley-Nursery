package com.MVNursery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Plant> plants = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Seed> seeds = new ArrayList<>();

}
