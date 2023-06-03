package com.rental.dto;

import java.util.List;

import com.rental.entites.Bikes;

import lombok.Data;

@Data
public class BrandDto {
	private Integer id;

	private String brandName;

	private String description;

	private String imgName;

//	private List<BikeDto> bike;

}
