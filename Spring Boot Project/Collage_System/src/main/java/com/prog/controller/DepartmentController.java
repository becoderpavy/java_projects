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

import com.prog.entity.Department;
import com.prog.model.DepartmentRequest;
import com.prog.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departService;

	@PostMapping("/save")
	public ResponseEntity<?> saveDepartment(@RequestBody DepartmentRequest depart) {
		return new ResponseEntity<>(departService.saveDepartment(depart), HttpStatus.CREATED);
	}

	@GetMapping("/{collageName}")
	public ResponseEntity<?> getDepartmentByCollageName(@PathVariable String collageName) {
		return new ResponseEntity<>(departService.getDepartmentByCollageName(collageName), HttpStatus.OK);
	}
	
	

}
