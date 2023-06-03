package com.railway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.entites.UserDtls;
import com.railway.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserDtls user) {

		if (userService.checkEmail(user.getEmail())) {
			return new ResponseEntity<>("Email id already Exist", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDtls userDtls) {
		return new ResponseEntity<>(userService.signInWithUserReturnJwt(userDtls), HttpStatus.OK);
	}

	@GetMapping("/forgotPassword/{em}/{no}")
	public ResponseEntity<?> checkEmailAndMob(@PathVariable String em, @PathVariable String no) {
		return new ResponseEntity<>(userService.checkEmailAndMob(em, no), HttpStatus.OK);
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody UserDtls user) {
		return new ResponseEntity<>(userService.resetPassword(user), HttpStatus.OK);
	}

}
