package com.realstate.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.realstate.entites.Home;
import com.realstate.entites.User;
import com.realstate.repository.UserRepository;
import com.realstate.service.AdminService;
import com.realstate.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home(Model m) {
		List<Home> list = adminService.getAllHome();
		m.addAttribute("list", list);
		return "user/index";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "user/edit_profile";
	}

	@GetMapping("/viewrealState/{id}")
	public String viewRealState(@PathVariable long id, Model m) {
		Home h = adminService.getHomeById(id);
		m.addAttribute("home", h);
		return "user/view_realstate";
	}

	@GetMapping("/search")
	public String search(@RequestParam("city") String city, Model m) {

		List<Home> list = adminService.getHomeBySearch(city);
		m.addAttribute("slist", list);
		return "user/search_home";
	}

	@PostMapping("/updateprofile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {

		User us = userService.updateProfile(user);
		if (us != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/user/view_profile";
	}

}
