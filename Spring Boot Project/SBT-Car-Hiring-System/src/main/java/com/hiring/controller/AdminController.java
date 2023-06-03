package com.hiring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.User;
import com.hiring.entites.Vechicle;
import com.hiring.repository.UserRepository;
import com.hiring.service.UserService;
import com.hiring.service.VechicleService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private VechicleService vechicleService;

	@ModelAttribute
	public void addCommonData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}

	@GetMapping("/all_vehicle")
	public String home(Model m) {
		List<Vechicle> list = vechicleService.getAllVechicle();
		m.addAttribute("vlist", list);
		return "admin/all_vehicle";
	}

	@GetMapping("/booking")
	public String getBook(Model m) {

		List<OrderBooking> list = userService.getAllBooking();
		m.addAttribute("blist", list);
		return "admin/book";
	}

}
