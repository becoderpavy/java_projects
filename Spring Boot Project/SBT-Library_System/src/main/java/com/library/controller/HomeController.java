package com.library.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entites.Book;
import com.library.entites.User;
import com.library.repository.UserRepository;
import com.library.service.BookService;
import com.library.service.CartService;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CartService cartService;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}

	}

	@GetMapping("/")
	public String home(Model m) {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/libLogin")
	public String libLogin() {
		return "lib_login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/addUser")
	public String registerUser(@ModelAttribute User user, HttpSession session) {

		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (userService.createUser(user) != null) {
			session.setAttribute("succMsg", "Register sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/register";
	}

	@GetMapping("/loadforgotPassword")
	public String loadForgotPassword() {
		return "forgot_password";
	}

	@GetMapping("/loadresetPassword/{id}")
	public String loadResetPassword(@PathVariable int id, Model m) {
		m.addAttribute("uid", id);
		return "reset_password";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, @RequestParam String mobno, HttpSession session) {
		User u = userService.chechUserEmailAndMobNo(email, mobno);

		if (u != null) {
			return "redirect:/loadresetPassword/" + u.getId();

		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			return "redirect:/loadforgotPassword";
		}

	}

	@PostMapping("/changePasswordx")
	public String changeNewPassword(@RequestParam String password, @RequestParam int uid, HttpSession session) {
		User user = userService.getUserById(uid);
		user.setPassword(passwordEncoder.encode(password));
		user.setId(uid);

		if (userService.updateUser(user) != null) {
			session.setAttribute("succMsg", "Password Change Sucessfully");
		} else {
			session.setAttribute("error", "Something wrong on server");
		}
		return "redirect:/loadforgotPassword";

	}

	@GetMapping("/books")
	public String books(Model m, @RequestParam(name = "category", defaultValue = "0") int id) {
		List<Book> list = null;
		if (id == 0) {
			list = bookService.getAllBook();
		} else {
			list = bookService.getBookByCategory(id);
		}
		m.addAttribute("books", list);
		m.addAttribute("category", bookService.getAllCategory());
		return "books";
	}
	

	@GetMapping("viewBook/{id}")
	public String viewBook(@PathVariable int id, Model m) {
		m.addAttribute("book", bookService.getBookById(id));
		m.addAttribute("cartService", cartService);
		return "view_book";
	}

	@PostMapping("/search")
	public String bookSearch(@RequestParam String ch, Model m) {
		m.addAttribute("books", bookService.getBookBySearch(ch));

		return "/search";
	}
	
	
}
