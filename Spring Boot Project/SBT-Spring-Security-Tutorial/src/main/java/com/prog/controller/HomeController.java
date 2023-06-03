package com.prog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/")
	public String home2()
	{
		return "signin";
	}

	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
}
