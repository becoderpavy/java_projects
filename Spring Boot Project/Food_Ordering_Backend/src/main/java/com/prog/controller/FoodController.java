package com.prog.controller;

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

import com.prog.entites.Food;
import com.prog.entites.UserDtls;
import com.prog.service.FoodService;
import com.prog.service.UserService;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> createFood(Food food, MultipartFile file) {
		return new ResponseEntity<>(foodService.createFood(food, file), HttpStatus.CREATED);
	}

	@GetMapping("/foodById/{id}")
	public ResponseEntity<?> getAllFood(@PathVariable Integer id) {
		return new ResponseEntity<>(foodService.getFoodById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllFood() {
		return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
	}

	@GetMapping("/getFoodByCategory/{id}")
	public ResponseEntity<?> getFoodByCategory(@PathVariable Integer id) {
		return new ResponseEntity<>(foodService.getFoodByCategory(id), HttpStatus.OK);
	}

	@GetMapping("/deleteFood/{id}")
	public ResponseEntity<?> deleteFood(@PathVariable Integer id) {
		foodService.deleteFood(id);
		return new ResponseEntity<>("Delete Sucesfully", HttpStatus.OK);
	}

	@PostMapping("/updateFood")
	public ResponseEntity<?> updateFood(Food food, MultipartFile img) {
		System.out.println(img);

		return new ResponseEntity<>(foodService.updateFood(food, img), HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(foodService.getAllUser(), HttpStatus.OK);
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody UserDtls user) {
		return new ResponseEntity<>(foodService.updateProfile(user), HttpStatus.OK);
	}

	@GetMapping("/searchFoodByCategory")
	public ResponseEntity<?> searchFoodByCategory(@RequestParam String ch, @RequestParam Integer cat) {
		return new ResponseEntity<>(foodService.searchFoodByCategory(ch, cat), HttpStatus.OK);
	}

}
