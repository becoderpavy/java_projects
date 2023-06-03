package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.User;
import com.example.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService uservice;

	@PostMapping
	public ResponseEntity<?> saveUser(User user, MultipartFile pic) {
		System.out.println(user);
		uservice.save(user, pic);
		return ResponseEntity.ok("saved");
	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(User user, MultipartFile pic, @PathVariable("id") int id) {
		user.setId(id);
		uservice.save(user, pic);
		return ResponseEntity.ok("updated");
	}

	@GetMapping
	public ResponseEntity<?> listall() {
		return ResponseEntity.ok(uservice.listall());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable("id") int id) {
		return ResponseEntity.ok(uservice.finduser(id));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		uservice.deleteById(id);
		return ResponseEntity.ok("deleted");
	}
}
