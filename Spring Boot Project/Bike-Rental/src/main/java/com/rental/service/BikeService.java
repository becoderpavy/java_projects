package com.rental.service;

import java.util.List;

import com.rental.dto.BikeDto;
import com.rental.entites.Bikes;

public interface BikeService {

	BikeDto createBike(BikeDto bike);
	
	BikeDto getBikeById(Integer id);
	
	List<BikeDto> getAllBikes();
	
	void deleteBikes(Integer id);
	
	boolean checkBikeNo(String bikeNo);
	
	BikeDto updateBike(Integer id,BikeDto bike);
	
}
