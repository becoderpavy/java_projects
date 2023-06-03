package com.rental.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.dto.BikeDto;
import com.rental.entites.Bikes;

@Component
public class BikeMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Bikes dtoToBike(BikeDto bikeDto) {
		return modelMapper.map(bikeDto, Bikes.class);
	}

	public BikeDto bikeToDto(Bikes bike) {
		return modelMapper.map(bike, BikeDto.class);
	}

}
