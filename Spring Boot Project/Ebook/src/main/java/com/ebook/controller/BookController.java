package com.ebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.dto.BookDto;
import com.ebook.entites.User;
import com.ebook.service.BookService;
import com.ebook.service.UserService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> createBook(BookDto book, MultipartFile file, HttpServletRequest request) {

		return new ResponseEntity<>(bookService.createBook(book, file), HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateBook(BookDto bookDto, MultipartFile file) {
		return new ResponseEntity<>(bookService.updateBook(bookDto, file), HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<?> getAllBookByPagination(

			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,

			@RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize,

			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,

			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
		return new ResponseEntity<>(bookService.getAllBooks(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllBook() {
		return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Integer id) {

		BookDto dto = bookService.getBookById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>("Delete Sucessfully", HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<?> countBook() {
		return new ResponseEntity<>(bookService.countData(), HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody User user) {
		return new ResponseEntity<>(bookService.updateProfile(user), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String ch) {
		//bookService.searchBook(ch).forEach((e) -> System.out.println(e.getImg()));
		return new ResponseEntity<>(bookService.searchBook(ch), HttpStatus.OK);
	}

}
