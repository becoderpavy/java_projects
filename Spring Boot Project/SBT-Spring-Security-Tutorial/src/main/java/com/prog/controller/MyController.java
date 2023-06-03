package com.prog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/signin")
	public String home2()
	{
		return "signin";
	}
	
	
	
	
	
	
}
