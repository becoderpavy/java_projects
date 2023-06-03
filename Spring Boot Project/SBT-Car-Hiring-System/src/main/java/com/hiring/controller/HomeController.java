package com.hiring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiring.entites.User;
import com.hiring.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/register")
	public String createUser(@ModelAttribute User user, HttpSession session) {

		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");

		if (userService.createUser(user)) {
			session.setAttribute("message", "Register sucessfully");
		} else {
			session.setAttribute("message", "Email already exist");
		}
		return "redirect:/signup";
	}

}
