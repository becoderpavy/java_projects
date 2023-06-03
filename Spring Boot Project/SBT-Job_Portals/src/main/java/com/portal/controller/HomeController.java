package com.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portal.entites.User;
import com.portal.repository.UserRepository;
import com.portal.service.AdminService;
import com.portal.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

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

	@PostMapping("createUser")
	public String createUser(@ModelAttribute User user, HttpSession session) {

		if (!userService.checkEmail(user.getEmail())) {

			if (userService.createUser(user) != null) {
				session.setAttribute("succMsg", "Register Sucessfully");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}

		} else {
			session.setAttribute("errorMsg", "email already exist");
		}

		return "redirect:/register";
	}

	@GetMapping("/addRecruiter")
	public String rregister() {
		return "recuiter_register";
	}

	@PostMapping("/createRecruiter")
	public String createRecriter(@ModelAttribute User user, HttpSession session) {
		if (!adminService.checkEmail(user.getEmail())) {

			if (adminService.createUser(user) != null) {
				session.setAttribute("succMsg", "Register Sucessfully");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}
		} else {
			session.setAttribute("errorMsg", "email already exist");
		}
		return "redirect:/addRecruiter";
	}

	@GetMapping("/userValidation")
	public String loadUserValidation() {
		return "user_validation";
	}

	@PostMapping("/checkUser")
	public String checkEmailAndMobNo(@RequestParam("email") String email, @RequestParam("mobNo") String mobNo,
			HttpSession session) {

		if (userService.checkEmailAndMob(email, mobNo)) {
			session.setAttribute("email", email);
			return "change_password";
		} else {
			session.setAttribute("errorMsg", "invalid email & mob no");
			return "redirect:/userValidation";
		}

	}

	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		User user = userRepo.findByEmail(email);
		user.setPassword(passwordEncode.encode(password));

		if (userService.updatePassword(user) != null) {
			session.setAttribute("succMsg", "Password Change Sucessfully");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/userValidation";
	}

}
