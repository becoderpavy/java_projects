package com.rental.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rental.entites.Home;
import com.rental.entites.UserDtls;
import com.rental.service.HomeService;

@RestController
@RequestMapping("/api/home")
public class HomeController {

	@Autowired
	public HomeService homeService;

	@PostMapping("/")
	public ResponseEntity<?> createHome(Home home, MultipartFile file, HttpServletRequest request) {
		System.out.println(home);
		return new ResponseEntity<>(homeService.createHome(home, file, request), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllHomeBySeller(HttpServletRequest request) {
		return new ResponseEntity<>(homeService.getAllHomeByUser(request), HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllHome() {
		return new ResponseEntity<>(homeService.getAllHome(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllHomeById(@PathVariable Integer id) {
		return new ResponseEntity<>(homeService.getHomeById(id), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateHome(HttpServletRequest request, Home home, MultipartFile file) {

		return new ResponseEntity<>(homeService.updateHome(request, home, file), HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteHome(@PathVariable int id) {
		homeService.deleteHome(id);
		return new ResponseEntity<>("Delete sucessfully", HttpStatus.OK);
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDtls user) {

		return new ResponseEntity<>(homeService.updateProfile(user), HttpStatus.OK);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(homeService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		homeService.deleteUser(id);
		return new ResponseEntity<>("Delete Sucessfully", HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String ch) {
		return new ResponseEntity<>(homeService.searchHome(ch), HttpStatus.OK);
	}

	

}
