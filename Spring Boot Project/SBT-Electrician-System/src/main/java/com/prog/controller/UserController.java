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

import com.prog.entites.Booking;
import com.prog.entites.User;
import com.prog.repository.UserRepository;
import com.prog.service.AdminService;
import com.prog.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
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
	public String home(Model m) {
		List<User> list = userService.getAllElectrician("ROLE_ELECTRICIAN");
		m.addAttribute("list", list);
		return "user/index";
	}

	@GetMapping("/viewElectrician/{id}")
	public String viewElectricain(@PathVariable long id, Model m) {
		User u = userService.getElectricianById(id);
		m.addAttribute("e", u);
		return "user/view_electrician";
	}

	@GetMapping("/search")
	public String search(@RequestParam("city") String city, Model m) {
		List<User> list = userService.getElectricianBySearch("ROLE_ELECTRICIAN", city);
		m.addAttribute("list", list);
		return "user/search";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "user/edit_profile";
	}

	@GetMapping("/book/{id}")
	public String book(@PathVariable long id, Model m) {
		User u = userService.getElectricianById(id);
		m.addAttribute("e", u);
		return "user/book";
	}

	@PostMapping("/updateProfile")
	public String updateELectrician(@ModelAttribute User user, @RequestParam("img") MultipartFile file,
			HttpSession session) {

		User oldUser = userService.getElectricianById(user.getId());

		try {

			if (!file.isEmpty()) {

				File deletefile = new ClassPathResource("static/user_profile").getFile();
				File f = new File(deletefile, oldUser.getFileName());
				f.delete();

				// update new photo
				File saveFile = new ClassPathResource("static/user_profile").getFile();
				// System.out.println(saveFile);
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				user.setFileName(file.getOriginalFilename());
			} else {
				user.setFileName(oldUser.getFileName());
			}

			User updateUser = userService.updateUserProfile(user);

			if (updateUser != null) {
				session.setAttribute("succMsg", "Update sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/user/viewProfile";
	}

	@PostMapping("/bookElectrician")
	public String bookElectrician(@ModelAttribute Booking book, HttpSession session) {

		Booking b = userService.book(book);

		if (b != null) {
			session.setAttribute("succMsg", "Booking sucessfully ! our electrician contact you shortly");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/user/book/" + book.getElectricianId();
	}

	@GetMapping("/viewBooking")
	public String getbooking(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		List<Booking> list = userService.getBookByUser(user.getId());

		m.addAttribute("list", list);
		m.addAttribute("userService", userService);
		return "user/view_booking";
	}

}
