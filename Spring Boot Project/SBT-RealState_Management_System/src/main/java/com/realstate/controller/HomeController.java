package com.realstate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.realstate.entites.User;
import com.realstate.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home Page");
		return "index";
	}

	@GetMapping("/signin")
	public String login(Model m) {
		m.addAttribute("title", "Login");
		return "login";
	}

	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("title", "Register");
		return "register";
	}

	@PostMapping("/createUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {

		if (!userService.checkEmail(user.getEmail())) {
			user.setRole("ROLE_USER");
			User us = userService.saveUser(user);
			if (us != null) {
				session.setAttribute("succMsg", "Register sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

		} else {
			session.setAttribute("errorMsg", "email id alredy exists");
		}
		return "redirect:/register";
	}

}
