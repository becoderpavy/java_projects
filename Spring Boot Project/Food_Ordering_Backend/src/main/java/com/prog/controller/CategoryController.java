package com.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Category;
import com.prog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<?> createCategory(Category category, MultipartFile file) {
		return new ResponseEntity<>(categoryService.createCategory(category, file), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateCategory(Category category, MultipartFile file) {
		return new ResponseEntity<>(categoryService.updateCategory(category, file), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String ch) {
		return new ResponseEntity<>(categoryService.searchCategory(ch), HttpStatus.OK);
	}

}
