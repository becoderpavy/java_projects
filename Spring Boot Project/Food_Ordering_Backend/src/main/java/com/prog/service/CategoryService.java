package com.prog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Category;

public interface CategoryService {

	Category createCategory(Category category, MultipartFile file);

	void deleteCategory(Integer id);

	Category getCategoryById(Integer id);

	List<Category> getAllCategory();

	Category updateCategory(Category category, MultipartFile file);

	public List<Category> searchCategory(String ch);
}
