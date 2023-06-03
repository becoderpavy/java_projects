package com.portal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.portal.entites.User;
import com.portal.repository.JobRepository;
import com.portal.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private JobRepository jobRepo;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/addRecruiter")
	public String rregister() {
		return "admin/recuiter_register";
	}

	@GetMapping("/jobs")
	public String alljobs(Model m) {
		m.addAttribute("list", jobRepo.findAll());
		return "admin/jobs";
	}

	@GetMapping("/viewJob/{id}")
	public String viewjob(@PathVariable long id, Model m) {
		m.addAttribute("j", jobRepo.findById(id).get());
		return "admin/view_job";
	}

	@GetMapping("/viewRecruiter")
	public String viewRecruiter(Model m) {
		List<User> list = adminService.getAllUser("ROLE_RECRUITER");
		m.addAttribute("list", list);
		return "admin/view_recruiter";
	}

	@GetMapping("/editRecruiter/{id}")
	public String editRecruiter(@PathVariable long id, Model m) {
		User u = adminService.getUserById(id);
		m.addAttribute("user", u);
		return "admin/edit_recuriter";
	}

	@GetMapping("/viewUser")
	public String viewUser(Model m) {
		List<User> list = adminService.getAllUser("ROLE_USER");
		m.addAttribute("list", list);
		return "admin/view_user";
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

		return "redirect:/admin/addRecruiter";
	}

	@PostMapping("/updateRec")
	public String updateRecriter(@ModelAttribute User user, HttpSession session) {

		if (adminService.updateUser(user) != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewRecruiter";
	}

	@GetMapping("/deleteRec/{id}")
	public String deleteRec(@PathVariable long id, HttpSession session) {

		if (adminService.deleteUser(id)) {
			session.setAttribute("succMsg", "Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewRecruiter";
	}

}
