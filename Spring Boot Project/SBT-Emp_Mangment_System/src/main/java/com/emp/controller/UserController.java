package com.emp.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.enties.User;
import com.emp.repository.ComplianceRepository;
import com.emp.repository.UserRepository;
import com.emp.service.AdminService;
import com.emp.service.ComplianceService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ComplianceService comService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home() {
		return "user/index";
	}

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User emp = userRepo.findByEmail(email);
		m.addAttribute("emp", emp);
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "user/edit_profile";
	}

	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute User user, HttpSession session) {

		User us = adminService.addEmp(user);
		if (us != null) {
			session.setAttribute("succMsg", "Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/user/viewProfile";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "user/change_password";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		User currentUser = userRepo.findByEmail(email);

		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncoder.encode(newPassword));
			userRepo.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}
		return "redirect:/user/changePassword";
	}

	@GetMapping("/complianceStatus")
	public String complianceStatus(Model m, Principal p) {

		String email = p.getName();
		User emp = userRepo.findByEmail(email);

		m.addAttribute("list", comService.getComplianceStatusByUser(emp.getId()));
		m.addAttribute("complianceService", comService);
		return "user/view_compliance";
	}

	@GetMapping("/compliance")
	public String getAllCompliance(Model m) {
		m.addAttribute("list", comService.getAllRL());
		return "user/compliance";
	}

}
