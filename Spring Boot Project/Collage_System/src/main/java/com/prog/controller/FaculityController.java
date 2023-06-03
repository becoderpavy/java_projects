package com.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.entity.Faculity;
import com.prog.model.FaculityRequest;
import com.prog.service.FaculityService;

@RestController
@RequestMapping("/faculity")
public class FaculityController {

	@Autowired
	private FaculityService faculityService;

	@PostMapping("/saveFaculity")
	public ResponseEntity<?> saveFaculity(@RequestBody FaculityRequest faculityRequest) {

		return new ResponseEntity<>(faculityService.saveFaculity(faculityRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getFaculity/{collageName}")
	public ResponseEntity<?> getFaculityByCollageName(@PathVariable String collageName) {
		return new ResponseEntity<>(faculityService.getFaculityByCollage(collageName), HttpStatus.OK);
	}

	@GetMapping("/getFaculityByDepart/{department}")
	public ResponseEntity<?> getFaculityByDepartment(@PathVariable String department) {
		return new ResponseEntity<>(faculityService.getFaculityByDepartment(department), HttpStatus.OK);
	}

}
