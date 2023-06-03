package com.ebook.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.entites.Book;
import com.ebook.entites.Category;
import com.ebook.entites.Orders;
import com.ebook.service.BookService;
import com.ebook.service.OrderService;
import com.ebook.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private BookService bookService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/category")
	public String category(Model m) {
		m.addAttribute("category", bookService.getAllCategory());
		return "admin/category";
	}

	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable int id, Model m) {
		m.addAttribute("category", bookService.getCategoryById(id));
		return "admin/edit_category";
	}

	@GetMapping("/book")
	public String addBook(Model m) {
		m.addAttribute("category", bookService.getAllCategory());
		m.addAttribute("books", bookService.getAllBook());
		m.addAttribute("bookService", bookService);
		return "admin/add_book";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(Model m, @PathVariable int id) {
		m.addAttribute("book", bookService.getBookById(id));
		m.addAttribute("category", bookService.getAllCategory());
		return "admin/edit_book";
	}

	@GetMapping("/orders")
	public String bookOrders(Model m) {
		m.addAttribute("orders", orderService.getAllOrders());
		m.addAttribute("bookService", bookService);
		m.addAttribute("userService", userService);
		return "admin/orders";
	}

	@GetMapping("/viewBook")
	public String viewBook(Model m) {
		m.addAttribute("category", bookService.getAllCategory());
		m.addAttribute("books", bookService.getAllBook());
		m.addAttribute("bookService", bookService);
		return "admin/view_book";
	}

	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute Category category, HttpSession session) {

		if (bookService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category Added Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
	}

	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, HttpSession session) {

		if (bookService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, HttpSession session) {

		if (bookService.deleteCategory(id)) {
			session.setAttribute("succMsg", "Category Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/category";
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
		return "redirect:/admin/book";
	}

	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book, @RequestParam("img") MultipartFile file, HttpSession session) {
		// System.out.println(file.isEmpty());
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
		return "redirect:/admin/viewBook";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, HttpSession session) {

		if (bookService.deleteBook(id)) {
			session.setAttribute("succMsg", "Book Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/viewBook";
	}

	@GetMapping("/ordStatus")
	public String orderStatusUpdate(@RequestParam("id") int id, @RequestParam("st") String st, HttpSession session,
			Model m) {
		
		Orders order = orderService.getOrderById(id);
		order.setId(id);
		order.setStatus(st);
		if (orderService.updateOrders(order) != null) {
			session.setAttribute("succMsg", "Order Status update success");
		} else {
			session.setAttribute("errorMsg", "Something wrong in servre");
		}
		return "redirect:/admin/orders";
	}

}
