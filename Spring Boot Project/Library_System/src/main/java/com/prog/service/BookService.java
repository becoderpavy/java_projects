package com.prog.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prog.entites.Book;

public interface BookService {

	Book addBook(Book book);

	List<Book> getAllBook();

	public Book getBookById(int id);

	boolean deleteBook(int id);

	public Page<Book> getAllBook(int pageNo, int pageSize);
	
	
	public List<Book> getBookBySearch(String ch) ;
}
