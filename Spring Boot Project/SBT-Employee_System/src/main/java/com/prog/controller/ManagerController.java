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
import com.prog.entites.Payslip;
import com.prog.entites.ProjectStatus;
import com.prog.repository.EmpRepository;
import com.prog.repository.PayslipRepository;
import com.prog.service.EmpService;
import com.prog.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private EmpService empService;

	@Autowired
	private PayslipRepository payslipRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);
		m.addAttribute("emp", emp);
	}

	@GetMapping("/")
	public String home() {
		return "manager/index";
	}

	@GetMapping("/viewEmp")
	public String viewEmp(Principal p, Model m) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		List<AssignManager> list = managerService.getAllAssignUserByManager(emp.getId());

		m.addAttribute("list", list);
		m.addAttribute("managerService", managerService);

		return "manager/view_emp";
	}

	@GetMapping("/assignProject/{id}")
	public String assignProject(@PathVariable long id, Model m) {
		m.addAttribute("e", managerService.getEmpById(id));
		return "manager/assign_project";
	}

	@GetMapping("/viewAssignProject")
	public String viewAssignProject(Model m, Principal p) {

		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		List<AssignManager> list = managerService.getAllAssignUserByManager(emp.getId());

		m.addAttribute("list", list);
		m.addAttribute("managerService", managerService);

		return "manager/veiw_project_assign";
	}

	@GetMapping("/projectStatus/{id}")
	public String projectStatus(@PathVariable long id, Model m, Principal p) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		m.addAttribute("projectId", managerService.getEmpById(id));
		m.addAttribute("assignProject", managerService.getByManagerAndUser(emp.getId(), id));

		m.addAttribute("projectStatus", managerService.getProjectStatus(emp.getId(), id));
		m.addAttribute("managerService", managerService);
		return "manager/project_status";
	}

	@GetMapping("/leave")
	public String leave(Model m, Principal p) {

		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);

		m.addAttribute("list", managerService.getAllLeavesByManager(emp.getId()));
		m.addAttribute("managerService", managerService);
		return "manager/leave";
	}

	@GetMapping("/helpline")
	public String helpline(Principal p, Model m) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);
		m.addAttribute("list", empService.getAllHelplineByEmpId(emp.getId()));
		return "manager/helpline";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "manager/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "manager/edit_profile";
	}

	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute Emp emp, HttpSession session) {

		return "redirect:/manager/viewProfile";
	}

	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute AssignManager as, HttpSession session) {

		if (managerService.updateProject(as) != null) {
			session.setAttribute("succMsg", "Project Assign Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/manager/viewEmp";
	}

	@PostMapping("/projectStatusUpdate")
	public String updateProjectStatus(@ModelAttribute ProjectStatus p, HttpSession session) {

		if (managerService.createProjectStatus(p) != null) {

		} else {

		}

		return "redirect:/manager/projectStatus/" + p.getUserId();
	}

	@GetMapping("/leaveupdate/{st}/{id}")
	public String leaveStatus(@PathVariable String st, @PathVariable long id, HttpSession session) {

		if (managerService.updateLeaveStatus(st, id) != null) {
			session.setAttribute("succMsg", "Leave update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/manager/leave";
	}

	@PostMapping("/addHelpline")
	public String addHelpline(@ModelAttribute Helpline h, HttpSession session) {

		if (empService.addHelpline(h) != null) {
			session.setAttribute("succMsg", "Issue submit Sucessfully ! admin team contact very soon");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/manager/helpline";
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

		return "manager/view_payslip";
	}

	@GetMapping("/changePassword")
	public String changePassword() {
		return "manager/change_password";
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
		return "redirect:/manager/changePassword";
	}
	
	@PostMapping("/profileUpdate")
	public String profileUpdate(@ModelAttribute Emp emp, HttpSession session) {

		if (empService.updateProfile(emp) != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/manager/viewProfile";
	}

}
