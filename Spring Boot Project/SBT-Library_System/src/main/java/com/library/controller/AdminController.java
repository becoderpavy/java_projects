package com.library.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.library.entites.LibraryDtls;
import com.library.entites.Orders;
import com.library.entites.User;
import com.library.repository.UserRepository;
import com.library.service.LibraryService;
import com.library.service.OrderService;
import com.library.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private LibraryService libService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/addLibrary")
	public String addLibrary() {
		return "admin/add_library";
	}

	@GetMapping("/library")
	public String viewLibrary(Model m) {
		m.addAttribute("lib", libService.getAllLibrary());
		return "admin/library";
	}

	@GetMapping("/viewLib")
	public String viewLib(Model m) {
		m.addAttribute("lib", libService.getAllLibrary());
		return "admin/view_lib";
	}

	@GetMapping("/user/{id}")
	public String user(Model m, @PathVariable int id) {

		LibraryDtls lib = libService.getLibById(id);

		m.addAttribute("lid", id);
		m.addAttribute("lib", userRepo.findByLibrary(lib));

		return "admin/user";
	}

	@GetMapping("/editLib/{id}")
	public String editLibrary(Model m, @PathVariable int id) {
		m.addAttribute("lib", libService.getLibById(id));
		return "admin/edit_library";
	}

	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable int id, Model m) {
		m.addAttribute("us", userService.getUserById(id));
		return "admin/edit_user";
	}

	@PostMapping("/registerLibrary")
	public String addBooks(@ModelAttribute LibraryDtls lib, @RequestParam("img") MultipartFile file,
			HttpSession session) {

		lib.setImage(file.getOriginalFilename());

		if (libService.saveLibrary(lib) != null) {

			try {
				File saveFile = new ClassPathResource("static/lib_img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				// System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Library Added Sucessfully");
		}
		return "redirect:/admin/addLibrary";
	}

	@PostMapping("/updateLib")
	public String updateLIb(@ModelAttribute LibraryDtls lib, @RequestParam("img") MultipartFile file,
			HttpSession session) {
		// System.out.println(file.isEmpty());

		if (!file.isEmpty()) {
			lib.setImage(file.getOriginalFilename());
		} else {
			LibraryDtls oldLibraryDtls = libService.getLibById(lib.getId());
			lib.setImage(oldLibraryDtls.getImage());
		}

		if (libService.saveLibrary(lib) != null) {

			try {
				if (!file.isEmpty()) {
					File saveFile = new ClassPathResource("static/lib_img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Library update Sucessfully");
		}
		return "redirect:/admin/library";
	}

	@GetMapping("/deleteLib/{id}")
	public String deleteLibk(@PathVariable int id, HttpSession session) {

		if (libService.deleteLibrary(id)) {
			session.setAttribute("succMsg", "Library Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/library";
	}

	@PostMapping("/addUser")
	public String registerUser(@ModelAttribute User user, HttpSession session, @RequestParam("lid") int lid) {

		LibraryDtls lib = libService.getLibById(lid);

		user.setRole("ROLE_LIBRIAN");
		user.setLibrary(lib);
		user.setAddress("NA");
		user.setState("NA");
		user.setCity("NA");
		user.setPincode("NA");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (userRepo.existsByEmail(user.getEmail())) {
			session.setAttribute("errorMsg", "Email exists");
		} else if (userRepo.existsByMobNo(user.getMobNo())) {
			session.setAttribute("errorMsg", "mobno exists");

		} else {
			if (userService.createUser(user) != null) {
				session.setAttribute("succMsg", "User Added sucessfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
		}
		return "redirect:/admin/user/" + lid;
	}

	@GetMapping("/deleteUser/{id}/{lid}")
	public String deleteUser(@PathVariable int id, HttpSession session, @PathVariable int lid) {

		if (userService.deleteUser(id)) {
			session.setAttribute("succMsg", "user delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/user/" + lid;
	}

	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute User user, HttpSession session, @RequestParam("lid") int lid) {

		LibraryDtls lib = libService.getLibById(lid);

		user.setRole("ROLE_LIBRIAN");
		user.setLibrary(lib);

		if (userService.createUser(user) != null) {
			session.setAttribute("succMsg", "User update sucessfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/admin/user/" + lid;
	}

}
