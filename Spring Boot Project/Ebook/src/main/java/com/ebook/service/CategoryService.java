package com.ebook.service;

import java.util.List;

import com.ebook.dto.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	void deleteCategory(Integer id);

	CategoryDto getCategoryById(Integer id);

	List<CategoryDto> getAllCategory();

	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

}
