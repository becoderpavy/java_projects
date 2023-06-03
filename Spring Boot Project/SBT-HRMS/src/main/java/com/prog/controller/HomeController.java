package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog.entites.Emp;
import com.prog.repository.EmpRepository;

@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmpRepository empRepo;

	@GetMapping("/")
	public String home() {
		
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		
		return "login";
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

		Emp emp = empRepo.findByEmailAndMobNo(email, mobno);

		if (emp != null) {
			return "redirect:/loadresetPassword/" + emp.getId();

		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			return "redirect:/loadforgotPassword";
		}

	}

	@PostMapping("/changePasswordx")
	public String changeNewPassword(@RequestParam String password, @RequestParam long uid, HttpSession session) {
		Emp emp = empRepo.findById(uid).get();
		emp.setPassword(passwordEncoder.encode(password));
		emp.setId(uid);

		if (empRepo.save(emp) != null) {
			session.setAttribute("succMsg", "Password Change Sucessfully");
		} else {
			session.setAttribute("error", "Something wrong on server");
		}
		return "redirect:/loadforgotPassword";

	}

}
