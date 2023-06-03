package com.rental.controller;

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

import com.rental.dto.BrandDto;
import com.rental.service.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/")
	public ResponseEntity<?> createBrands(@RequestBody BrandDto brand) {
		return new ResponseEntity<>(brandService.createBrands(brand), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> getBrands() {
		return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBrandsById(@PathVariable Integer id) {
		return new ResponseEntity<>(brandService.getBrandsById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBrands(@PathVariable Integer id) {
		brandService.deleteBrands(id);
		return new ResponseEntity<>("Brand Delete sucessfully", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBrands(@PathVariable Integer id, @RequestBody BrandDto brand) {
		return new ResponseEntity<>(brandService.updateBrands(id, brand), HttpStatus.CREATED);
	}

}
