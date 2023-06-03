package com.prog.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Category;
import com.prog.exception.ResourceNotFoundException;
import com.prog.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Value("${project.category.image}")
	private String path;

	@Autowired
	private FileService fileService;

	@Override
	public Category createCategory(Category category, MultipartFile file) {

		if (file.isEmpty()) {
			category.setImage("default.jpg");
		} else {
			category.setImage(file.getOriginalFilename());
		}
		Category cat = categoryRepo.save(category);
		if (cat != null) {
			try {
				fileService.uploadImage(path, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return cat;
	}

	@Override
	public Category getCategoryById(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		return category;
	}

	@Override
	public List<Category> getAllCategory() {

		return categoryRepo.findAll();
	}

	@Override
	public Category updateCategory(Category category, MultipartFile file) {
		Category cat = categoryRepo.findById(category.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getId()));

		if (file.isEmpty()) {
			category.setImage(cat.getImage());
		} else {
			category.setImage(file.getOriginalFilename());
		}
		Category updateCat = categoryRepo.save(category);
		if (cat != null) {
			if (!file.isEmpty()) {
				try {
					fileService.uploadImage(path, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCat;
	}

	@Override
	public void deleteCategory(Integer id) {

		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

		categoryRepo.delete(category);
	}
	
	@Override
	public List<Category> searchCategory(String ch) {
		return categoryRepo.search(ch);
	}

}
