package com.prog.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Booking;
import com.prog.entites.User;
import com.prog.repository.UserRepository;
import com.prog.service.AdminService;
import com.prog.service.UserService;

@Controller
@RequestMapping("/electrician")
public class ElectricianController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
		return "electrician/index";
	}

	@GetMapping("/viewBooking")
	public String booking(Model m,Principal p) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		List<Booking> list = userService.getBookByElectrician(user.getId());

		m.addAttribute("list", list);
		m.addAttribute("userService", userService);
		return "electrician/view_booking";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "electrician/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "electrician/edit_profile";
	}

	@PostMapping("/updateProfile")
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
				// System.out.println(saveFile);
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

		return "redirect:/electrician/viewProfile";
	}

}
