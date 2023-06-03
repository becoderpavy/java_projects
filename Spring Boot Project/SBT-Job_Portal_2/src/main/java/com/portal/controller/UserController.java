package com.portal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import org.springframework.web.multipart.MultipartFile;

import com.portal.entites.Candidates;
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

	@GetMapping("/appliedJob")
	public String appliedJob(Model m, Principal p) {

		String email = p.getName();
		User user = userRepository.findByEmail(email);
		List<Candidates> list = userService.getAppliedJobByUser(user.getId());
		m.addAttribute("list", list);
		m.addAttribute("userService", userService);
		return "user/applied_job";
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

	@PostMapping("/createCandidates")
	public String createCandidates(@ModelAttribute Candidates c, @RequestParam("resume") MultipartFile file,
			HttpSession session) {

		c.setFileName(file.getOriginalFilename());
		if (userService.saveCandidates(c) != null) {

			try {

				File saveFile = new ClassPathResource("static/resume").getFile().getAbsoluteFile();

				Path path = Paths.get(saveFile + File.separator + file.getOriginalFilename());
				System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}

			session.setAttribute("succMsg", "Job Apply Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/user/viewJob/" + c.getJobId();
	}

	@GetMapping("/downloadResume/{id}")
	public void downloadResume(@PathVariable long id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Candidates c = userService.getCandidateById(id);
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/resume").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + c.getFileName());

			File file = new File(path + "");

			if (file.exists()) {

				/**** Setting The Content Attributes For The Response Object ****/

				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				/**** Setting The Headers For The Response Object ****/

				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				/**** Get The Output Stream Of The Response ****/

				outStream = response.getOutputStream();
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				/****
				 * Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data
				 * Read From The Input Stream Into The Output Stream
				 ***/
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} catch (IOException ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

			outStream.flush();
			if (outStream != null) {
				outStream.close();
			}
		}

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
	public String search(@RequestParam("ch") String ch, Model m) {

		List<Jobs> list = jobRepo.searchJob(ch, ch, ch, ch);
		m.addAttribute("list", list);
		m.addAttribute("clist", jobRepo.findAll());
		return "/user/search";
	}

	@GetMapping("/download/{fileName}")
	public void downloadAssignment(@PathVariable String fileName, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/user_resume").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + fileName);

			File file = new File(path + "");

			if (file.exists()) {

				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				outStream = response.getOutputStream();
				inputStream = new FileInputStream(file);
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
		} catch (IOException ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			outStream.flush();
			if (outStream != null) {
				outStream.close();
			}
		}

	}

}
