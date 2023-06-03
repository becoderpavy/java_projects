package com.portal.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portal.entites.Jobs;
import com.portal.entites.User;
import com.portal.repository.JobRepository;
import com.portal.repository.UserRepository;
import com.portal.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JobRepository jobRepo;

	public static int BUFFER_SIZE = 1024 * 100000;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/{pageNo}")
	public String home(@PathVariable int pageNo, Model m) {
		Page<Jobs> page = userService.getAllJob(pageNo, 5);

		m.addAttribute("currentPage", pageNo);
		m.addAttribute("totalElements", page.getTotalElements());
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("list", page.getContent());

		m.addAttribute("clist", jobRepo.findAll());

		return "user/index";
	}

	@GetMapping("/viewJob/{id}")
	public String viewJob(@PathVariable long id, Model m) {
		Jobs j = userService.getJobById(id);

		m.addAttribute("j", j);
		m.addAttribute("userService", userService);
		return "user/view_job";
	}

	@GetMapping("/viewProfile")
	public String viewprofile() {
		return "user/view_profile";
	}

	@GetMapping("/editProfile")
	public String editprofile() {
		return "user/edit_profile";
	}

	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {

		if (userService.updateProfile(user) != null) {
			session.setAttribute("succMsg", "Profile update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/user/viewProfile";
	}

	@GetMapping("/changePassword")
	public String lchangePassword() {
		return "user/change_password";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		User currentUser = userRepository.findByEmail(email);

		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}

		return "redirect:/user/changePassword";
	}

	@PostMapping("/search")
	public String search(@RequestParam("cn") String cn, @RequestParam("lo") String lo, Model m) {

		List<Jobs> list = jobRepo.findByCompanyNameAndLocation(cn, lo);
		m.addAttribute("list", list);
		m.addAttribute("clist", jobRepo.findAll());
		return "/user/search";
	}

}
