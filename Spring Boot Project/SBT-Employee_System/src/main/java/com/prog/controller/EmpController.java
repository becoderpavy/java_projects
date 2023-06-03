package com.prog.controller;

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

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Helpline;
import com.prog.entites.Leave;
import com.prog.entites.Payslip;
import com.prog.entites.ProjectStatus;
import com.prog.repository.EmpRepository;
import com.prog.repository.PayslipRepository;
import com.prog.service.EmpService;
import com.prog.service.ManagerService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private EmpService empService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private PayslipRepository payslipRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home() {
		return "emp/index";
	}

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);
		m.addAttribute("emp", emp);
	}

	@GetMapping("/viewAssignProject")
	public String viewAssignProject(Model m, Principal p) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		m.addAttribute("list", empService.getProjectDetailsByUser(emp.getId()));
		m.addAttribute("managerService", managerService);
		return "emp/veiw_project_assign";
	}

	@GetMapping("/projectStatus/{projectId}")
	public String projectStatus(Model m, Principal p, @PathVariable long projectId) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		AssignManager projectDetails = empService.getDetailsByProjectId(projectId);

		Emp managerDetails = managerService.getEmpById(projectDetails.getManagerId());

		List<ProjectStatus> list = managerService.getProjectStatus(projectDetails.getManagerId(), emp.getId());

		m.addAttribute("manager", managerDetails);
		m.addAttribute("projectStatusList", list);
		m.addAttribute("projectDetails", projectDetails);
		return "emp/project_status";
	}

	@GetMapping("/leave")
	public String leave(Model m, Principal p) {

		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		m.addAttribute("list", empService.getLeaveByUserId(emp.getId()));

		m.addAttribute("empService", empService);
		return "emp/leave";
	}

	@GetMapping("/helpdesk")
	public String helpdesk(Model m, Principal p) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);
		m.addAttribute("list", empService.getAllHelplineByEmpId(emp.getId()));
		return "emp/helpline";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "emp/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "emp/edit_profile";
	}

	

	@PostMapping("/projectStatusUpdate")
	public String updateProjectStatus(@ModelAttribute ProjectStatus p, HttpSession session) {

		if (managerService.createProjectStatus(p) != null) {

		} else {

		}

		return "redirect:/emp/projectStatus/" + p.getProjectId();
	}

	@PostMapping("/addLeave")
	public String addLeave(@ModelAttribute Leave l, HttpSession session) {

		if (empService.saveLeave(l) != null) {
			session.setAttribute("succMsg", "Leave Apply Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/emp/leave";
	}

	@PostMapping("/addHelpline")
	public String addHelpline(@ModelAttribute Helpline h, HttpSession session) {

		if (empService.addHelpline(h) != null) {
			session.setAttribute("succMsg", "Issue submit Sucessfully ! admin team contact very soon");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/emp/helpdesk";
	}

	@GetMapping("/download/{id}")
	public void downloadPayslip(@PathVariable long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Payslip p = payslipRepo.findById(id).get();
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		try {
			File saveFile = new ClassPathResource("static/payslip").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + p.getFileName());

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
				byte[] buffer = new byte[1024 * 1000000];
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

	@GetMapping("/viewPaySlip")
	public String viewPayslip(Model m, Principal p) {

		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		m.addAttribute("list", payslipRepo.findByEmpId(emp.getId()));

		return "emp/view_payslip";
	}

	@PostMapping("/profileUpdate")
	public String profileUpdate(@ModelAttribute Emp emp, HttpSession session) {

		if (empService.updateProfile(emp) != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/emp/viewProfile";
	}
	
	
	@GetMapping("/changePassword")
	public String changePassword() {
		return "emp/change_password";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		Emp currentUser = empRepo.findByEmail(email);

		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncoder.encode(newPassword));
			empRepo.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}
		return "redirect:/emp/changePassword";
	}

}
