package com.rental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.dto.UserDto;
import com.rental.service.UserService;

@RestController
@RequestMapping("/api/user")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

		if (userService.checkEmail(userDto.getEmail())) {
			return new ResponseEntity<>("Email id alreday exists", HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.signInWithUserReturnJwt(userDto), HttpStatus.OK);
	}

}
