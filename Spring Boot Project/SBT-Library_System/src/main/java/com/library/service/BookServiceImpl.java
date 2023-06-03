package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entites.Book;
import com.library.entites.Category;
import com.library.repository.BookRepository;
import com.library.repository.CategoryRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepo;

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
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}

	@Override
	public boolean deleteBook(int id) {
		Book b = bookRepo.findById(id).get();
		if (b != null) {
			bookRepo.delete(b);
			return true;
		}
		return false;
	}

	@Override
	public List<Book> getBookByCategory(int id) {
		return bookRepo.findByCategortId(id);
	}

	@Override
	public List<Book> getBookBySearch(String ch) {

		return bookRepo.findByBookNameSearch(ch);
	}

}
