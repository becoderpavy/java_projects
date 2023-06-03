package com.rental.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BikeDto {

	private Integer id;

	@NotEmpty
	private String bikeName;

	@NotEmpty
	private String modelNo;

	@NotEmpty
	private String bikeNo;

	@NotEmpty
	private String color;

	@NotEmpty
	private String description;

	private Double perDay;

	@NotEmpty
	private String imgName;

	@NotNull
	private BrandDto brand;

}
