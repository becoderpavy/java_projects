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

import com.prog.entity.HOD;
import com.prog.model.HodRequest;
import com.prog.service.HodService;

@RestController
@RequestMapping("/hod")
public class HODController {

	@Autowired
	private HodService hodService;

	@PostMapping("/assignHod")
	public ResponseEntity<?> assignHod(@RequestBody HodRequest hodRequest) {
		return new ResponseEntity<>(hodService.assignDepartment(hodRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getHodDepart/{departmentName}")
	public ResponseEntity<?> getHodByDepartment(@PathVariable String departmentName) {
		return new ResponseEntity<>(hodService.getHodByDepartment(departmentName), HttpStatus.OK);
	}

}
