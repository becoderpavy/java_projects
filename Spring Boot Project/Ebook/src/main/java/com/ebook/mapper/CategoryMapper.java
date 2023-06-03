package com.ebook.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.dto.CategoryDto;
import com.ebook.entites.Category;

@Component
public class CategoryMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Category dtoToCategory(CategoryDto categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}

	public CategoryDto categoryToDto(Category category) {
		return this.modelMapper.map(category, CategoryDto.class);
	}
	
}
