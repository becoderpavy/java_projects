package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prog.entites.Book;
import com.prog.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

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
	public Page<Book> getAllBook(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return bookRepo.findAll(pageable);
	}

	@Override
	public List<Book> getBookBySearch(String ch) {

		return bookRepo.findByBookNameSearch(ch, ch, ch);
	}
}
