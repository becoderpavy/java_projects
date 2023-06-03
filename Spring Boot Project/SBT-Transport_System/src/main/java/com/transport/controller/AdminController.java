package com.transport.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.entites.Feedback;
import com.transport.entites.User;
import com.transport.service.UserService;
import com.transport.service.VehicleService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/")
	public String home(Model m) {
		return "admin/index";
	}

	@GetMapping("/addManager")
	public String addManager() {
		return "admin/add_manager";
	}

	@GetMapping("/editManager/{id}")
	public String editManager(@PathVariable int id, Model m) {
		m.addAttribute("user", userService.getUserById(id));
		return "admin/edit_manager";
	}

	@GetMapping("/viewManager")
	public String viewManager(Model m) {
		m.addAttribute("list", userService.getAllUser());
		return "admin/view_manager";
	}

	@GetMapping("/viewQueries")
	public String viewQuries(Model m) {
		m.addAttribute("list", userService.getAllFeedback());
		return "admin/view_queries";
	}

	@GetMapping("/viewVehicle")
	public String viewVehicle(Model m) {
		m.addAttribute("list", vehicleService.getAllVehicle());
		return "admin/view_vehicle";
	}

	@PostMapping("/createManager")
	public String createUser(@ModelAttribute User user, HttpSession session) {

		logger.debug("*** createUser() Exceution Started ***");

		user.setRole("ROLE_MANAGER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		if (userService.checkUserName(user.getUserName())) {

			logger.debug("*** checkUserName()- username already exists ***");

			session.setAttribute("errorMsg", "username already exists");
		} else if (userService.checkEmail(user.getEmail())) {

			logger.debug("*** checkEmail()- email id already exists ***");

			session.setAttribute("errorMsg", "email id already exists");
		} else {
			User us = userService.createUser(user);
			if (us != null) {
				logger.debug("*** createUser()- User Register sucesfully***");
				session.setAttribute("succMsg", "Register sucesfully");
			}
		}
		return "redirect:/admin/addManager";
	}

	@PostMapping("/updateManager")
	public String updateUser(@ModelAttribute User user, HttpSession session) {

		User us = userService.createUser(user);
		if (us != null) {
			session.setAttribute("succMsg", "Update sucesfully");
		}

		return "redirect:/admin/viewManager";
	}

	@GetMapping("/deleteManager/{id}")
	public String deleteManager(@PathVariable int id, HttpSession session) {

		if (userService.deleteUser(id)) {
			session.setAttribute("succMsg", "Delete sucesfully");
		}
		return "redirect:/admin/viewManager";
	}

	@PostMapping("/updateFeedback")
	public String createFeedback(@RequestParam("id") int id, @RequestParam("response") String response,
			HttpSession session) {

		Feedback feed = userService.getFeedbackById(id);
		feed.setResponse(response);
		if (userService.createFeedback(feed) != null) {

			session.setAttribute("succMsg", "Quries Update sucesfully");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewQueries";
	}
}
