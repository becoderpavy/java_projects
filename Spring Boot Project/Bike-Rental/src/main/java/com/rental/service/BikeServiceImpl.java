package com.rental.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.dto.BikeDto;
import com.rental.entites.Bikes;
import com.rental.exception.ResourceNotFoundException;
import com.rental.mapper.BikeMapper;
import com.rental.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private BikeRepository bikeRepo;

	@Autowired
	private BikeMapper bikeMapper;

	@Override
	public BikeDto createBike(BikeDto bikeDto) {
		Bikes bikes = bikeMapper.dtoToBike(bikeDto);
		return bikeMapper.bikeToDto(bikeRepo.save(bikes));
	}

	@Override
	public BikeDto getBikeById(Integer id) {
		return bikeMapper
				.bikeToDto(bikeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike", "Id", id)));
	}

	@Override
	public List<BikeDto> getAllBikes() {
		return bikeRepo.findAll().stream().map((bike) -> bikeMapper.bikeToDto(bike)).collect(Collectors.toList());
	}

	@Override
	public void deleteBikes(Integer id) {
		Bikes bike = bikeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike", "Id", id));

		if (bike != null) {
			bikeRepo.delete(bike);

		}
	}

	@Override
	public boolean checkBikeNo(String bikeNo) {
		return bikeRepo.existsByBikeNo(bikeNo);
	}

	@Override
	public BikeDto updateBike(Integer id, BikeDto bikeDto) {
		Bikes oldBike = bikeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike", "Id", id));
		bikeDto.setId(oldBike.getId());

		Bikes bikes = bikeMapper.dtoToBike(bikeDto);

		return bikeMapper.bikeToDto(bikeRepo.save(bikes));
	}

}
