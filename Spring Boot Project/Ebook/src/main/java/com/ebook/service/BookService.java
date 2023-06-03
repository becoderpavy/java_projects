package com.ebook.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.ebook.dto.BookDto;
import com.ebook.entites.Books;
import com.ebook.entites.User;
import com.ebook.payloads.BookResponse;
import com.ebook.payloads.CountDetails;


public interface BookService {

	public BookDto createBook(BookDto bookDto, MultipartFile file);

	public BookDto updateBook(BookDto bookDto, MultipartFile file);

	public void deleteBook(Integer id);

	BookResponse getAllBooks(int pageNo, int pageSize, String sortBy, String sortDir);

	List<BookDto> getAllBook();

	public void getImage(String imgName, HttpServletResponse response) throws IOException;

	BookDto getBookById(Integer id);

	CountDetails countData();

	User updateProfile(User user);

	public List<BookDto> searchBook(String ch);
	
}
