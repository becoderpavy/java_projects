package com.ebook.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ebook.entites.Book;
import com.ebook.entites.Category;

public interface BookService {

	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(int id);
	
	boolean deleteCategory(int id);
	
	Book addBook(Book book);
	
	List<Book> getAllBook();
	
	Book getBookById(int id);
	
	boolean deleteBook(int id);
	
	List<Book> getBookByCategory(int id);
	
	List<Book> getBookBySearch(String ch);
	

}
