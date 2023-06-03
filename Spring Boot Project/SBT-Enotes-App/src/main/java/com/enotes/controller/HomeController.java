package com.enotes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enotes.entity.UserDtls;
import com.enotes.helper.Messgae;
import com.enotes.repository.UserRepository;
import com.enotes.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("user", null);
		return "signup";
	}

	@PostMapping("/do_register")
	public String register(@ModelAttribute UserDtls user,
			@RequestParam(value = "agree", defaultValue = "false") boolean agree, Model m, HttpSession session) {

		try {
			if (agree == false) {
				session.setAttribute("message", new Messgae("You have not agreed Terms & Condition", "text-danger"));
				return "redirect:/signup";
			}
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			if (userRepo.existsByEmail(user.getEmail())) {
				session.setAttribute("message", new Messgae("Email Id already Exist", "text-danger"));
			} else {
				boolean isSaved = userService.register(user);
				if (isSaved) {
					session.setAttribute("message", new Messgae("Register Sucessfully", "text-success"));
				} else {
					session.setAttribute("message", new Messgae("Something wrong on server", "text-danger"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/signup";
	}

}
