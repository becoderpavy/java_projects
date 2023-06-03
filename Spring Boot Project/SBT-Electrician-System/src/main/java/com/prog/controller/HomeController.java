package com.prog.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.User;
import com.prog.service.AdminService;
import com.prog.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user, @RequestParam("img") MultipartFile file, HttpSession session) {

		if (!userService.checkEmail(user.getEmail())) {
			user.setFileName(file.getOriginalFilename());

			User Newuser = userService.addUser(user);
			if (Newuser != null) {

				try {
					File saveFile = new ClassPathResource("static/user_profile").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (IOException e) {
					e.printStackTrace();
				}

				session.setAttribute("succMsg", "Register sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
		} else {
			session.setAttribute("errorMsg", "email id exist");
		}

		return "redirect:/register";
	}

	@GetMapping("/addElectrician")
	public String addElectrician() {
		return "add_electrician";
	}

	@PostMapping("/createElectrician")
	public String createElectrician(@ModelAttribute User user, @RequestParam("img") MultipartFile file,
			HttpSession session) {

		if (!adminService.checkEmail(user.getEmail())) {
			user.setFileName(file.getOriginalFilename());

			User Newuser = adminService.addEletrician(user);
			if (Newuser != null) {

				try {
					File saveFile = new ClassPathResource("static/elcetrician_profile").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (IOException e) {
					e.printStackTrace();
				}

				session.setAttribute("succMsg", "Register sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
		} else {
			session.setAttribute("errorMsg", "email id exist");
		}

		return "redirect:/addElectrician";
	}

}
