package com.prog.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog.entity.Student;
import com.prog.repository.StudentRepository;
import com.prog.service.StudentService;

@Controller
@RequestMapping("/user")
public class StudentController {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private StudentService studentService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		Student user = studentService.getUserByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/home")
	public String home(Principal p, Model m) {

		return "user/home";
	}

	@GetMapping("/edit")
	public String edit(Principal p, Model m) {

		return "user/edit";
	}

	@PostMapping("/update")
	public String register(@ModelAttribute Student u, HttpSession session) {

		Student oldUser = studentService.getUserById(u.getId());
		u.setPassword(oldUser.getPassword());
		u.setRole(oldUser.getRole());

		studentService.registerStudent(u);
		session.setAttribute("message", " Profile Update Sucessfully..");

		return "redirect:/user/edit";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "user/change_password";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		Student currentUser = repo.findByEmail(email);

		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncoder.encode(newPassword));
			repo.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}

		return "redirect:/user/changePassword";
	}

}
