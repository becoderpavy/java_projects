package com.portal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

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

import com.portal.entites.Candidates;
import com.portal.entites.Jobs;
import com.portal.entites.User;
import com.portal.repository.UserRepository;
import com.portal.service.RecruiterService;
import com.portal.service.UserService;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	public static int BUFFER_SIZE = 1024 * 100000;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home() {
		return "recruiter/index";
	}

	@GetMapping("/viewUser")
	public String user(Model m) {
		m.addAttribute("us", userRepository.findByRoleOrderByIdDesc("ROLE_USER"));
		return "recruiter/user";
	}

	@GetMapping("/addJobs")
	public String addJobs() {
		return "recruiter/add_job";
	}

	@GetMapping("/viewJobs")
	public String viewJobs(Model m, Principal p) {

		String email = p.getName();
		User user = userRepository.findByEmail(email);

		List<Jobs> list = recruiterService.getJobsByRecruiterId(user.getId());
		m.addAttribute("list", list);

		return "recruiter/view_jobs";
	}

	@GetMapping("/viewJob/{id}")
	public String viewOneJob(@PathVariable long id, Model m) {

		Jobs j = recruiterService.getJobById(id);
		m.addAttribute("j", j);
		return "recruiter/view_job";
	}

	@GetMapping("/editJob/{id}")
	public String editJob(@PathVariable long id, Model m) {
		Jobs j = recruiterService.getJobById(id);
		m.addAttribute("j", j);
		return "recruiter/edit_job";
	}

	@GetMapping("/viewCandidates")
	public String viewCandidates(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		List<Jobs> list = recruiterService.getJobsByRecruiterId(user.getId());
		m.addAttribute("list", list);
		m.addAttribute("recruiterService", recruiterService);
		return "recruiter/view_candidates";
	}

	@GetMapping("/viewCandidatesJob/{jid}")
	public String viewCandidatesByJob(Principal p, @PathVariable long jid, Model m) {

		String email = p.getName();
		User user = userRepository.findByEmail(email);

		List<Candidates> list = recruiterService.getAllCandidatesByRecruiter(user.getId(), jid);

		m.addAttribute("recruiterService", recruiterService);
		m.addAttribute("list", list);
		return "recruiter/candidates";
	}

	@GetMapping("/viewProfile")
	public String viewprofile() {
		return "recruiter/view_profile";
	}

	@GetMapping("/editProfile")
	public String editprofile() {
		return "recruiter/edit_profile";
	}

	@PostMapping("/createJob")
	public String createJob(@ModelAttribute Jobs job, HttpSession session) {

		if (recruiterService.addJob(job) != null) {
			session.setAttribute("succMsg", "Jobs Added Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/recruiter/addJobs";
	}

	@PostMapping("/updateJob")
	public String updateJob(@ModelAttribute Jobs job, HttpSession session) {

		if (recruiterService.addJob(job) != null) {
			session.setAttribute("succMsg", "Jobs Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/recruiter/viewJob/" + job.getId();
	}

	@GetMapping("/deleteJob/{id}")
	public String deleteJob(@PathVariable long id, HttpSession session) {

		if (recruiterService.deleteJob(id)) {
			session.setAttribute("succMsg", "Jobs Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/recruiter/viewJobs/";
	}

	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {

		if (recruiterService.updateProfile(user) != null) {
			session.setAttribute("succMsg", "profile update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/recruiter/viewProfile";
	}

	@GetMapping("/downloadResume/{id}")
	public void downloadAssignmentAnswer(@PathVariable long id, HttpServletRequest request,
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

	@GetMapping("/downloadRes/{rfile}")
	public void downloadResume(@PathVariable String rfile, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/user_resume").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + rfile);
			//System.out.println(path);
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
		return "recruiter/change_password";
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

		return "redirect:/recruiter/changePassword";
	}

	@GetMapping("/cardPayment")
	public String cardPayment() {
		return "recruiter/payment";
	}

	@GetMapping("/search")
	public String search(@RequestParam("ch") String ch, Model m) {

		m.addAttribute("searchUser", userRepository.searchUser(ch, ch));

		return "recruiter/user";
	}

}
