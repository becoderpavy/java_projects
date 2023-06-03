package com.prog.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Book;
import com.prog.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, Model m) {

		Page<Book> page = bookService.getAllBook(pageNo, 1);
		// bookService.getAllBook(pageNo, 1).getContent().forEach(e ->
		// System.out.println(e));

		m.addAttribute("pageNo", pageNo);
		m.addAttribute("totalElement", page.getTotalElements());
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("book", page.getContent());

		return "index";
	}

	@GetMapping("/addBook")
	public String addBook() {
		return "add_book";
	}

	@GetMapping("/viewBook")
	public String viewBook(Model m) {
		m.addAttribute("books", bookService.getAllBook());
		return "view_book";
	}

	@PostMapping("/addBooks")
	public String addBooks(@ModelAttribute Book book, @RequestParam("img") MultipartFile file, HttpSession session) {

		book.setImgName(file.getOriginalFilename());

		if (bookService.addBook(book) != null) {

			try {
				File saveFile = new ClassPathResource("static/book_img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				// System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Book Added Sucessfully");
		}
		return "redirect:/addBook";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(Model m, @PathVariable int id) {
		m.addAttribute("book", bookService.getBookById(id));
		return "edit_book";
	}

	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book, @RequestParam("img") MultipartFile file, HttpSession session) {

		if (!file.isEmpty()) {
			book.setImgName(file.getOriginalFilename());
		} else {
			Book oldBook = bookService.getBookById(book.getId());
			book.setImgName(oldBook.getImgName());
		}

		if (bookService.addBook(book) != null) {

			try {
				if (!file.isEmpty()) {
					File saveFile = new ClassPathResource("static/book_img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Book update Sucessfully");
		}
		return "redirect:/viewBook";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, HttpSession session) {

		if (bookService.deleteBook(id)) {
			session.setAttribute("succMsg", "Book Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/viewBook";
	}

	@GetMapping("viewBook/{id}")
	public String viewBook(@PathVariable int id, Model m) {
		m.addAttribute("book", bookService.getBookById(id));
		return "view_books";
	}
	
	@PostMapping("/search")
	public String bookSearch(@RequestParam String ch, Model m) {
		m.addAttribute("books", bookService.getBookBySearch(ch));
		return "/search";
	}

}
