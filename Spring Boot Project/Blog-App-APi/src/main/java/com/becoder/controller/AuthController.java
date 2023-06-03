package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.exception.ApiException;
import com.becoder.jwtconfig.JwtAuthRequest;
import com.becoder.jwtconfig.JwtAuthResponse;
import com.becoder.jwtconfig.JwtTokenHelper;
import com.becoder.payloads.UserDto;
import com.becoder.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request) throws Exception {
		this.authenticate(request.getEmail(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String generateToken = jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setToken(generateToken);
		return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);

	}

	private void authenticate(String email, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,
				password);

		try {
			authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid details");
			throw new ApiException("inavalid email & Password");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestBody UserDto userDto) {
		System.out.println(userDto);
		return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
	}

}
