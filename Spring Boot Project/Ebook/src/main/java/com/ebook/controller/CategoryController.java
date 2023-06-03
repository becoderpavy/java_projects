package com.ebook.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.ebook.dto.CategoryDto;
import com.ebook.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id) {
		return new ResponseEntity<>(categoryService.updateCategory(categoryDto, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}

}
