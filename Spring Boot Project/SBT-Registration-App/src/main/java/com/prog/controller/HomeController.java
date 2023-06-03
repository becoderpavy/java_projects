package com.prog.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class HomeController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("/home")
	public String home(Principal p,Model m) {
		String em=p.getName();
		UserDtls u=repo.findByEmail(em);
		m.addAttribute("user",u);
		return "home";
	}

}
