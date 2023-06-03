package com.prog.service;

import java.util.List;

import com.prog.entites.Bag;
import com.prog.entites.Category;

public interface BagService {

	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(int id);

	boolean deleteCategory(int id);

	Bag addBook(Bag book);

	List<Bag> getAllBook();

	Bag getBookById(int id);

	boolean deleteBook(int id);

	List<Bag> getBookByCategory(int id);

	List<Bag> getBookBySearch(String ch);

}
