package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entites.User;
import com.prog.repository.UserRepository;
import com.prog.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/saveUser")
	public String registerUser(@ModelAttribute User user, HttpSession session) {

		if (!userService.checkEmail(user.getEmail())) {
			if (userService.saveUser(user) != null) {
				session.setAttribute("succMsg", "Register Sucessfully");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}

		} else {
			session.setAttribute("errorMsg", "Email id already exist");
		}

		return "redirect:/register";
	}

}
