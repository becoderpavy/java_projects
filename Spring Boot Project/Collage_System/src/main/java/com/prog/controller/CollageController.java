package com.prog.controller;

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

import com.prog.entity.Collage;
import com.prog.service.CollageService;

@RestController
@RequestMapping("/collage")
public class CollageController {

	@Autowired
	private CollageService collageService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCollage(@RequestBody Collage collage) {

		if (collageService.existCollageName(collage.getCollageName())) {
			return new ResponseEntity<>("Collage Name Already Exists", HttpStatus.OK);
		}
		return new ResponseEntity<>(collageService.saveCollage(collage), HttpStatus.CREATED);
	}

	@GetMapping("/getAllCollage")
	public ResponseEntity<?> getAllCollage() {
		return new ResponseEntity<>(collageService.getAllCollage(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCollageById(@PathVariable int id) {

		return new ResponseEntity<>(collageService.getCollageById(id), HttpStatus.OK);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<?> getCollageById(@PathVariable String name) {
		return new ResponseEntity<>(collageService.getCollageByName(name), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCollage(@RequestBody Collage c, @PathVariable int id) {
		return new ResponseEntity<>(collageService.updateCollage(c, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCollage(@PathVariable int id) {
		collageService.deleteCollage(id);
		return new ResponseEntity<>("Delete Sucessfully", HttpStatus.OK);
	}

}
