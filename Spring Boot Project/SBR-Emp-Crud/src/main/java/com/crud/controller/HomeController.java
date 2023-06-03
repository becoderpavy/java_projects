package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Emp;
import com.crud.repo.EmpRepo;

import lombok.Delegate;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class HomeController {

	@Autowired
	private EmpRepo empRepo;

	@GetMapping("/emp")
	public ResponseEntity<List<Emp>> getAllEmp() {
		// empRepo.findAll().forEach(e->System.out.println(e));

		return new ResponseEntity<List<Emp>>(empRepo.findAll(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Emp> createEmp(@RequestBody Emp emp) {
		return new ResponseEntity<Emp>(empRepo.save(emp), HttpStatus.CREATED);
	}

	@GetMapping("/emp/{id}")
	public ResponseEntity<Emp> getEmpByid(@PathVariable(name = "id") int id) {
		return new ResponseEntity<Emp>(empRepo.findById(id).get(), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp emp){
		return new ResponseEntity<Emp>(empRepo.save(emp),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<HttpStatus> deleteEmp(@PathVariable int id){
		empRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	

}
