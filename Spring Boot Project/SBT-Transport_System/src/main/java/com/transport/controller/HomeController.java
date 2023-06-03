package com.transport.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.transport.entites.User;
import com.transport.repository.UserRepo;
import com.transport.service.UserService;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

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

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user, HttpSession session) {

		logger.debug("*** createUser() Exceution Started ***");

		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		if (userService.checkUserName(user.getUserName())) {

			logger.debug("*** checkUserName()- username already exists ***");

			session.setAttribute("errorMsg", "username already exists");
		}

		else if (userService.checkEmail(user.getEmail())) {

			logger.debug("*** checkEmail()- email id already exists ***");
			session.setAttribute("errorMsg", "email id already exists");
		}

		else {
			User us = userService.createUser(user);
			if (us != null) {
				logger.debug("*** createUser()- User Register sucesfully***");
				session.setAttribute("succMsg", "Register sucesfully");
			}

		}

		return "redirect:/register";
	}

}
