package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Student;
import com.prog.repository.StudentRepository;
import com.prog.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private BCryptPasswordEncoder bp;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Student u, HttpSession session) {

		if (studentService.existContactNo(u.getContactNo())) {
			session.setAttribute("message", "contact no alreday exist");
			return "redirect:/signup";
		} else if (studentService.existEmail(u.getEmail())) {
			session.setAttribute("message", "Email alreday exist");
			return "redirect:/signup";
		} else {
			u.setPassword(bp.encode(u.getPassword()));
			u.setRole("ROLE_USER");

			studentService.registerStudent(u);
			session.setAttribute("message", " Register Sucessfully..");

			return "redirect:/signup";
		}

	}

}
