package com.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/allUser")
	public String allUser() {
		return "admin/all_user";
	}

	@GetMapping("/editUser")
	public String editUser() {
		return "admin/edit_user";
	}

	@GetMapping("/application")
	public String Application() {
		return "admin/application";
	}

	@GetMapping("/viewApplication")
	public String viewApplication() {
		return "admin/view_application";
	}

	@GetMapping("/message")
	public String message() {
		return "admin/message";
	}

}
