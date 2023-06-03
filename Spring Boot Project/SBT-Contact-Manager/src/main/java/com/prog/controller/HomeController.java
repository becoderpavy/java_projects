package com.prog.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog.entites.User;
import com.prog.helper.Message;
import com.prog.repo.ContactRepository;
import com.prog.repo.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home : SCM");
		return "home";
	}

	@GetMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			@RequestParam(value = "agree", defaultValue = "false") boolean agree, Model m, HttpSession session) {

		try {

			if (!agree) {
				System.out.println("You have not agreed Terms & Condition");
				throw new Exception("You have not agreed Terms & Condition");
			}

			if (result.hasErrors()) {
				m.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User u = repo.save(user);

			m.addAttribute("user", new User());
			session.setAttribute("message", new Message("Registration Success", "alert-success"));

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("user", user);
			session.setAttribute("message", new Message(e.getMessage(), "alert-danger"));
		}

		return "signup";

	}

	@GetMapping("/signin")
	public String customLogin(Model m) {
		return "login";
	}
	
	
}
