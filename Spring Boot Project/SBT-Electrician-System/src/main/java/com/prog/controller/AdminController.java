package com.prog.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.User;
import com.prog.repository.UserRepository;
import com.prog.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/addElectrician")
	public String addElectrician() {
		return "admin/add_electrician";
	}

	@GetMapping("/viewElectrician")
	public String viewElectrician(Model m) {

		List<User> list = adminService.getAllElectrician("ROLE_ELECTRICIAN");

		m.addAttribute("title", "view electrician");
		m.addAttribute("list", list);

		return "admin/view_electrician";
	}

	@GetMapping("/editElectrician/{id}")
	public String editElectrician(@PathVariable long id, Model m) {

		User user = adminService.getELectrician(id);

		m.addAttribute("title", "Edit Electrician");
		m.addAttribute("e", user);
		return "admin/edit_electrician";
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

		return "redirect:/admin/addElectrician";
	}

	@PostMapping("/updateElectrician")
	public String updateELectrician(@ModelAttribute User user, @RequestParam("img") MultipartFile file,
			HttpSession session) {

		User oldUser = adminService.getELectrician(user.getId());

		try {

			if (!file.isEmpty()) {

				File deletefile = new ClassPathResource("static/elcetrician_profile").getFile();
				File f = new File(deletefile, oldUser.getFileName());
				f.delete();

				// update new photo
				File saveFile = new ClassPathResource("static/elcetrician_profile").getFile();
				System.out.println(saveFile);
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				user.setFileName(file.getOriginalFilename());
			} else {
				user.setFileName(oldUser.getFileName());
			}

			User updateUser = adminService.updateElectrician(user);

			if (updateUser != null) {
				session.setAttribute("succMsg", "Update sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/viewElectrician";
	}

	@GetMapping("/deleteElectrician/{id}")
	public String deleteElectrician(@PathVariable long id, HttpSession session) {

		boolean f = adminService.deleteElectrician(id);

		if (f) {
			session.setAttribute("succMsg", "Delete sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/admin/viewElectrician";
	}

}
