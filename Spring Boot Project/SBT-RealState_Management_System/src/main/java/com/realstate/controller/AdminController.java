package com.realstate.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realstate.entites.Home;
import com.realstate.entites.User;
import com.realstate.repository.UserRepository;
import com.realstate.service.AdminService;
import com.realstate.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "admin/view_profile";
	}

	@PostMapping("/updateprofile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {

		User us = userService.updateProfile(user);
		if (us != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/viewProfile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "admin/edit_profile";
	}

	@GetMapping("/addHome")
	public String Addhome() {
		return "admin/add_home";
	}

	@GetMapping("/viewHome")
	public String viewhome(Model m) {
		List<Home> list = adminService.getAllHome();
		m.addAttribute("list", list);
		return "admin/view_home";
	}

	@GetMapping("/editHome/{id}")
	public String edithome(@PathVariable long id, Model m) {

		Home h = adminService.getHomeById(id);
		m.addAttribute("home", h);
		return "admin/edit_home";
	}

	@GetMapping("/viewUser")
	public String viewUser(Model m) {
		List<User> list = adminService.getAllUser();
		m.addAttribute("list", list);
		return "admin/view_user";
	}

	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable long id, Model m) {
		User user = adminService.getUserById(id);
		m.addAttribute("user", user);
		return "admin/edit_user";
	}

	@GetMapping("/viewOneHome/{id}")
	public String viewOneHome(@PathVariable long id, Model m) {
		Home h = adminService.getHomeById(id);
		m.addAttribute("home", h);
		return "admin/view_one_home";
	}

	@PostMapping("/createHome")
	public String addHome(@ModelAttribute Home h, HttpSession session, @RequestParam("img") MultipartFile file) {

		h.setFileName(file.getOriginalFilename());

		Home home = adminService.AddHome(h);
		if (home != null) {

			try {
				File saveFile = new ClassPathResource("static/home_img").getFile();

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

		return "redirect:/admin/addHome";
	}

	@PostMapping("/updatehome")
	public String updateHome(@ModelAttribute Home h, HttpSession session, @RequestParam("img") MultipartFile file) {

		Home oldhome = adminService.getHomeById(h.getId());

		try {

			if (!file.isEmpty()) {

				File deletefile = new ClassPathResource("static/home_img").getFile();
				File f = new File(deletefile, oldhome.getFileName());
				f.delete();

				// update new photo
				File saveFile = new ClassPathResource("static/home_img").getFile();
				// System.out.println(saveFile);
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				h.setFileName(file.getOriginalFilename());
			} else {
				h.setFileName(oldhome.getFileName());
			}

			Home updateHome = adminService.AddHome(h);

			if (updateHome != null) {
				session.setAttribute("succMsg", "Update sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/viewHome";
	}

	@GetMapping("/deleteHome/{id}")
	public String deleteHome(@PathVariable long id, HttpSession session) {
		boolean f = adminService.deleteHome(id);
		if (f) {
			session.setAttribute("succMsg", "Delete sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/viewHome";
	}

}