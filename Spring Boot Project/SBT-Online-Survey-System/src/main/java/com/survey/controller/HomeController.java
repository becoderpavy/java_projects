package com.survey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.survey.entity.UserDtls;
import com.survey.helper.Messages;
import com.survey.service.SurveyServiceImpl;
import com.survey.service.UserServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UserServiceImpl userService;
	
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "Home Page");
		return "home";
	}

	@GetMapping("/signin")
	public String login(Model m) {
		m.addAttribute("title", "Login Page");
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("user", new UserDtls());
		m.addAttribute("title", "Signup Page");
		return "signup";
	}

	@PostMapping("/register")
	public String userRegister(@ModelAttribute("userDtls") UserDtls userDtls, HttpSession session, Model m) {
		userDtls.setRole("ROLE_USER");
		userDtls.setPassword(passwordEncoder.encode(userDtls.getPassword()));

		if (userService.checkEmail(userDtls.getEmail())) {
			UserDtls user = userService.createUser(userDtls);
			if (user != null) {
				session.setAttribute("message", new Messages("Register Successfully", "text-success"));
				return "redirect:/signup";
			} else {
				m.addAttribute("user", userDtls);
				session.setAttribute("message", new Messages("Something wrong on server", "text-danger"));
				return "redirect:/signup";
			}
		} else {
			m.addAttribute("user", userDtls);
			session.setAttribute("message", new Messages("user email id already exist", "text-danger"));
			return "redirect:/signup";
		}
	}

}
