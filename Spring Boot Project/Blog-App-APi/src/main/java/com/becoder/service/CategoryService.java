package com.becoder.service;

import java.util.List;

import com.becoder.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto getCategoryById(Integer id);

	List<CategoryDto> getAllCategory();

	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

	void deleteCategory(Integer id);

}
