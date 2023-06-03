package com.enotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.entites.UserDtls;
import com.enotes.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	public AuthService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody UserDtls user) {
		System.out.println(user);
		if (userService.checkUserName(user.getUserName())) {
			return new ResponseEntity<>("username already exist", HttpStatus.CONFLICT);
		}

		if (userService.checkEmail(user.getEmail())) {
			return new ResponseEntity<>("email already exist", HttpStatus.CONFLICT);
		}
		
	

		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDtls u) {
		return new ResponseEntity<>(userService.signinWIthUserReturnJWT(u), HttpStatus.OK);
	}

}
