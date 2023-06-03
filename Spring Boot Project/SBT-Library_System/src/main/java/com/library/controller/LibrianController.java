package com.library.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

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

import com.library.entites.Book;
import com.library.entites.Category;
import com.library.entites.IssueBook;
import com.library.entites.LibraryDtls;
import com.library.entites.Orders;
import com.library.entites.User;
import com.library.repository.BookRepository;
import com.library.repository.IssueBookRepository;
import com.library.repository.UserRepository;
import com.library.service.BookService;
import com.library.service.LibraryService;
import com.library.service.OrderService;
import com.library.service.UserService;

@Controller
@RequestMapping("/librian")
public class LibrianController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BookService bookService;

	@Autowired
	private LibraryService libService;

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private IssueBookRepository issueBookRepo;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@ModelAttribute
	public User addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		return user;
	}

	@GetMapping("/")
	public String index() {
		return "librian/index";
	}

	@GetMapping("/category")
	public String category(Model m) {
		m.addAttribute("category", bookService.getAllCategory());
		return "librian/category";
	}

	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable int id, Model m) {
		m.addAttribute("category", bookService.getCategoryById(id));
		return "librian/edit_category";
	}

	@GetMapping("/book")
	public String addBook(Model m) {
		m.addAttribute("category", bookService.getAllCategory());
		m.addAttribute("books", bookService.getAllBook());
		m.addAttribute("bookService", bookService);
		return "librian/add_book";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(Model m, @PathVariable int id) {
		m.addAttribute("book", bookService.getBookById(id));
		m.addAttribute("category", bookService.getAllCategory());
		return "librian/edit_book";
	}

	@GetMapping("/viewBook")
	public String viewBook(Model m, Principal p) {

		User user = addCommnData(p, m);

		m.addAttribute("category", bookService.getAllCategory());
		m.addAttribute("books", bookRepo.findByLibrary(user.getLibrary()));
		m.addAttribute("bookService", bookService);
		return "librian/view_book";
	}

	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute Category category, HttpSession session) {

		if (bookService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category Added Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/librian/category";
	}

	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, HttpSession session) {

		if (bookService.addCategory(category) != null) {
			session.setAttribute("succMsg", "Category update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/librian/category";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, HttpSession session) {

		if (bookService.deleteCategory(id)) {
			session.setAttribute("succMsg", "Category Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/librian/category";
	}

	@PostMapping("/addBooks")
	public String addBooks(@ModelAttribute Book book, @RequestParam("img") MultipartFile file, HttpSession session,
			Principal p) {

		book.setImgName(file.getOriginalFilename());

		String email = p.getName();
		User user = userRepo.findByEmail(email);

		book.setLibrary(user.getLibrary());

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
		return "redirect:/librian/book";
	}

	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute Book book, @RequestParam("img") MultipartFile file, HttpSession session,
			Principal p) {
		// System.out.println(file.isEmpty());
		String email = p.getName();
		User user = userRepo.findByEmail(email);

		book.setLibrary(user.getLibrary());

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
		return "redirect:/librian/viewBook";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, HttpSession session) {

		if (bookService.deleteBook(id)) {
			session.setAttribute("succMsg", "Book Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/librian/viewBook";
	}

	@GetMapping("/issueBook")
	public String issueBook(Model m, Principal p) {

		User user = addCommnData(p, m);

		m.addAttribute("bookList", bookRepo.findByLibrary(user.getLibrary()));
		m.addAttribute("st", "no");
		return "librian/issue_book";
	}

	@GetMapping("/status")
	public String status(Model m) {
		m.addAttribute("st", "no");
		return "librian/status";
	}

	@PostMapping("/searchIssueBookStatus")
	public String searchIssueBookStatus(@RequestParam("email") String email, Model m, Principal p) {

		m.addAttribute("st", "yes");
		m.addAttribute("us", userRepo.findByEmail(email.trim()));
		return "librian/status";
	}

	@GetMapping("/bookStatus/{id}")
	public String bookStatus(@PathVariable int id, Model m) {

		User user = userRepo.findById(id).get();

		m.addAttribute("userList", issueBookRepo.findByUser(user));
		return "librian/book_status";
	}

	@PostMapping("/searchIssueBook")
	public String search(@RequestParam("email") String email, Model m, Principal p) {

		User user = addCommnData(p, m);

		m.addAttribute("bookList", bookRepo.findByLibrary(user.getLibrary()));
		m.addAttribute("st", "yes");
		m.addAttribute("us", userRepo.findByEmail(email.trim()));
		return "librian/issue_book";
	}

	@PostMapping("/applyIssueBook")
	public String applyIssueBook(@ModelAttribute IssueBook issue, Model m, HttpSession session, Principal p) {

		User user = userRepo.findById(issue.getUserId()).get();

		User libUser = addCommnData(p, m);

		LibraryDtls lib = libService.getLibById(libUser.getLibrary().getId());
		Book book = bookRepo.findById(issue.getBookId()).get();

		issue.setUser(user);
		issue.setLibrary(lib);
		issue.setBook(book);

		if (libService.appyIssueBook(issue) != null) {
			session.setAttribute("succMsg", "Book Issued Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/librian/issueBook";
	}

	@GetMapping("/orders")
	public String bookOrders(Model m, Principal p) {

		User librian = addCommnData(p, m);

		m.addAttribute("orders", orderService.getAllOrdersByLibraian(librian.getLibrary()));
		m.addAttribute("bookService", bookService);
		m.addAttribute("userService", userService);
		return "librian/orders";
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
			session.setAttribute("errorMsg", "Something wrong in server");
		}
		return "redirect:/librian/orders";
	}

	@GetMapping("/bookStatusUpdate")
	public String bookStatusUpdate(@RequestParam("id") int id, @RequestParam("st") String st, HttpSession session) {

		IssueBook isueBook = issueBookRepo.findById(id).get();
		isueBook.setStatus(st);

		if (issueBookRepo.save(isueBook) != null) {
			session.setAttribute("succMsg", "Book issues Status update success");
		} else {
			session.setAttribute("errorMsg", "Something wrong in server");
		}
		return "redirect:/librian/bookStatus/" + isueBook.getUser().getId();
	}
}
