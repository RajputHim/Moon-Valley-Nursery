package com.MVNursery.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;

	@NotNull(message = "plant height can not be null")
	private Integer plantHeight;
	@NotNull
	private String plantSpread;
	@NotNull
	private String commonName;
	@NotNull
	private String bloomTime;
	@NotNull
	private String medicinalOrCulinaryUse;
	@NotNull
	private String difficultyLevel;
	@NotNull
	private String temperature;

	@NotNull
	private String typeOfPlant;
	@NotNull
	private String plantDescription;
	@NotNull
	private Integer plantStock;

	@NotNull(message = "plant cost can not be null")
	private Double plantCost;

}
