package com.ebook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dto.CategoryDto;
import com.ebook.entites.Category;
import com.ebook.exception.ResourceNotFoundException;
import com.ebook.mapper.CategoryMapper;
import com.ebook.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = categoryMapper.dtoToCategory(categoryDto);

		return categoryMapper.categoryToDto(categoryRepo.save(category));
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		return categoryMapper.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		return categoryRepo.findAll().stream().map(e -> categoryMapper.categoryToDto(e)).collect(Collectors.toList());
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		category.setId(id);
		category.setCategoryName(categoryDto.getCategoryName());
		category.setDescription(categoryDto.getDescription());

		return categoryMapper.categoryToDto(categoryRepo.save(category));
	}

	
	

	@Override
	public void deleteCategory(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		categoryRepo.delete(category);
	}

}
