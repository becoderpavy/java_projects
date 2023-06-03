package com.rental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.dto.BikeDto;
import com.rental.entites.Bikes;
import com.rental.service.BikeService;

@RestController
@RequestMapping("/api/bike")
public class BikeController {

	@Autowired
	private BikeService bikeService;

	@PostMapping("/")
	public ResponseEntity<?> createBike(@Valid @RequestBody BikeDto bike) {

		if (bikeService.checkBikeNo(bike.getBikeNo())) {
			return new ResponseEntity<>("Bike No Already Exists", HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(bikeService.createBike(bike), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllBikes() {
		return new ResponseEntity<>(bikeService.getAllBikes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBikeById(@PathVariable Integer id) {
		return new ResponseEntity<>(bikeService.getBikeById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBike(@PathVariable Integer id) {
		bikeService.deleteBikes(id);
		return new ResponseEntity<>("Bike Details Delete Sucessfully", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBikes(@PathVariable Integer id, @Valid @RequestBody BikeDto bike) {

		return new ResponseEntity<>(bikeService.updateBike(id, bike), HttpStatus.OK);
	}

}
