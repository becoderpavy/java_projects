package com.adm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/")
	public String home() {
		return "user/index";
	}

	@GetMapping("/admissionForm")
	public String admissionForm() {
		return "user/admission_form";
	}

	@GetMapping("/myApplication")
	public String myApplication() {
		return "user/my_application";
	}

	@GetMapping("/viewApplication")
	public String viewApplication() {
		return "user/view_application";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "user/edit_profile";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "user/change_password";
	}

}
