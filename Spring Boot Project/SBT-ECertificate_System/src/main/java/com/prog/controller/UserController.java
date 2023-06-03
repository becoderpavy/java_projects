package com.prog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;
import com.prog.entites.User;
import com.prog.repository.UserRepository;
import com.prog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
		return "user/index";
	}

	@GetMapping("/applyBirth")
	public String applyBirth() {
		return "user/apply_birth";
	}

	@GetMapping("/applyMarriage")
	public String applyMarriage() {
		return "user/apply_marrige";
	}

	@GetMapping("/applyDeath")
	public String applyDeath() {
		return "user/apply_death";
	}

	@GetMapping("/statusBirth")
	public String statusBirth(Model m, Principal p) {

		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("list", userService.getAllBirthByUserId(user.getId()));
		return "user/status_birth";
	}

	@GetMapping("/statusDeath")
	public String statusDeath(Model m, Principal p) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("list", userService.getAllDeathByUserId(user.getId()));
		return "user/status_death";
	}

	@GetMapping("/statusMarriage")
	public String statusMarriage(Model m, Principal p) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("list", userService.getAllMarriageByUserId(user.getId()));
		return "user/status_marriage";
	}

	@GetMapping("/viewBirth/{id}")
	public String viewBirth(@PathVariable long id, Model m) {
		m.addAttribute("birth", userService.getBirthById(id));
		return "user/view_birth";
	}

	@GetMapping("/viewDeath/{id}")
	public String viewDeath(@PathVariable long id, Model m) {
		m.addAttribute("death", userService.getDeathById(id));
		return "user/view_death";
	}

	@GetMapping("/viewMarriage/{id}")
	public String viewMarriage(@PathVariable long id, Model m) {
		m.addAttribute("ma", userService.getMarriageById(id));
		return "user/view_marriage";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "user/edit_profile";
	}

	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {
		if (userService.updateUser(user) != null) {
			session.setAttribute("succMsg", "Profile Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/user/editProfile";
	}

	

	@PostMapping("/saveBirth")
	public String saveBirth(@ModelAttribute Birth b, @RequestParam("file") MultipartFile file, HttpSession session) {

		b.setDocumentProof(file.getOriginalFilename());

		if (userService.saveBirth(b) != null) {

			try {
				File saveFile = new ClassPathResource("static/upload_birth").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}

			session.setAttribute("succMsg", "Birth Form Apply Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/user/applyBirth";
	}

	@PostMapping("/saveMarriage")
	public String saveMarriage(@ModelAttribute Marrige m, @RequestParam("file") MultipartFile file,
			HttpSession session) {

		m.setProofDocument(file.getOriginalFilename());
		if (userService.saveMarriage(m) != null) {
			try {
				File saveFile = new ClassPathResource("static/upload_marrige").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Marrige Form Apply Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/user/applyMarriage";
	}

	@PostMapping("/saveDeath")
	public String saveDeath(@ModelAttribute Death d, @RequestParam("file") MultipartFile file, HttpSession session) {

		d.setProofDocument(file.getOriginalFilename());

		if (userService.saveDeath(d) != null) {
			try {
				File saveFile = new ClassPathResource("static/upload_death").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("succMsg", "Death Form Apply Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/user/applyDeath";
	}

	@GetMapping("/printBirth/{id}")
	public String printBirth(@PathVariable long id, Model m) {
		m.addAttribute("birth", userService.getBirthById(id));
		return "user/print_birth";
	}

	@GetMapping("/printDeath/{id}")
	public String printDeath(@PathVariable long id, Model m) {
		m.addAttribute("death", userService.getDeathById(id));
		return "user/print_death";
	}

	@GetMapping("/printMarriage/{id}")
	public String printMarriage(@PathVariable long id, Model m) {
		m.addAttribute("ma", userService.getMarriageById(id));
		return "user/print_marriage";
	}

	@GetMapping("/changePassword")
	public String changePassword() {

		return "user/change_password";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		User currentUser = userRepository.findByEmail(email);

		if (passwordEncode.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncode.encode(newPassword));
			userRepository.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}

		return "redirect:/user/changePassword";
	}
	
}
