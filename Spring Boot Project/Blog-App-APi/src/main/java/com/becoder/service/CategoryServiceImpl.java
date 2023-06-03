package com.becoder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.entites.Category;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.payloads.CategoryDto;
import com.becoder.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = DtoToCategory(categoryDto);

		return categoryToDto(categoryRepo.save(category));
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		return categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		return categoryRepo.findAll().stream().map(e -> categoryToDto(e)).collect(Collectors.toList());
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		category.setId(id);
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		return categoryToDto(categoryRepo.save(category));
	}

	@Override
	public void deleteCategory(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		categoryRepo.delete(category);
	}

	private CategoryDto categoryToDto(Category category) {
		return modelMapper.map(category, CategoryDto.class);
	}

	private Category DtoToCategory(CategoryDto categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}

}
