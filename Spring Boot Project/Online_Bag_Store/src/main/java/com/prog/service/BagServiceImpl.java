package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Bag;
import com.prog.entites.Category;
import com.prog.repository.BagRepository;
import com.prog.repository.CategoryRepository;

@Service
public class BagServiceImpl implements BagService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BagRepository bookRepo;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {

		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public boolean deleteCategory(int id) {
		Category cat = categoryRepository.findById(id).get();
		if (cat != null) {
			categoryRepository.delete(cat);
			return true;
		}
		return false;
	}

	@Override
	public Bag addBook(Bag book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Bag> getAllBook() {
		return bookRepo.findAll();
	}

	@Override
	public Bag getBookById(int id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public boolean deleteBook(int id) {
		Bag b = bookRepo.findById(id).get();
		if (b != null) {
			bookRepo.delete(b);
			return true;
		}
		return false;
	}

	@Override
	public List<Bag> getBookByCategory(int id) {
		return bookRepo.findByCategortId(id);
	}

	@Override
	public List<Bag> getBookBySearch(String ch) {

		return bookRepo.findByBookNameSearch(ch);
	}

}
