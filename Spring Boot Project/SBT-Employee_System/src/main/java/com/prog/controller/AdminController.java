package com.prog.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Payslip;
import com.prog.repository.PayslipRepository;
import com.prog.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/")
	public String home() {
		return "admin/index";
	}

	@GetMapping("/addEmp")
	public String addEmp() {
		return "admin/add_emp";
	}

	@GetMapping("/viewEmp")
	public String viewEmp(Model m) {
		List<Emp> list = adminService.getEmpByRoles("ROLE_USER");
		m.addAttribute("list", list);
		return "admin/view_emp";
	}

	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable long id, Model m) {
		Emp emp = adminService.getEmpById(id);
		m.addAttribute("e", emp);
		return "admin/edit_emp";
	}

	@GetMapping("/viewMang")
	public String viewMang(Model m) {
		List<Emp> list = adminService.getEmpByRoles("ROLE_MANAGER");
		m.addAttribute("list", list);
		return "admin/view_mang";
	}

	@GetMapping("/editMang/{id}")
	public String editMang(@PathVariable long id, Model m) {
		Emp emp = adminService.getEmpById(id);
		m.addAttribute("e", emp);
		return "admin/edit_mang";
	}

	@GetMapping("/viewAssMang")
	public String viewAssignManag(Model m) {
		m.addAttribute("list", adminService.getEmpByRoles("ROLE_USER"));
		m.addAttribute("adminService", adminService);
		return "admin/view_mang_assign";
	}

	@GetMapping("/assMang/{id}")
	public String AssignManag(@PathVariable long id, Model m) {
		m.addAttribute("e", adminService.getEmpById(id));
		m.addAttribute("manager", adminService.getEmpByRoles("ROLE_MANAGER"));
		return "admin/assign_manager";
	}

	@GetMapping("/viewQuery")
	public String viewQuery(Model m) {
		m.addAttribute("list", adminService.getHelpline());
		return "admin/emp_query";
	}

	@GetMapping("/responseQuery/{id}")
	public String responseQuery(@PathVariable long id, Model m) {
		m.addAttribute("help", adminService.getHelpLineById(id));
		return "admin/resp_query";
	}

	@PostMapping("/createEmp")
	public String addEmp(@ModelAttribute Emp emp, HttpSession session) {

		if (!adminService.checkEmail(emp.getEmail())) {

			Emp emps = adminService.addEmp(emp);
			if (emps != null) {
				session.setAttribute("succMsg", "Register Sucessfully");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}
		} else {
			session.setAttribute("errorMsg", "email id alreday exist");
		}

		return "redirect:/admin/addEmp";
	}

	@PostMapping("/updateProfile")
	public String updateEmp(@ModelAttribute Emp emp, HttpSession session) {

		Emp updateEmp = adminService.updateEmp(emp);
		if (updateEmp != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewEmp";
	}

	@PostMapping("/updateManagerProfile")
	public String updateManagerEmp(@ModelAttribute Emp emp, HttpSession session) {

		Emp updateEmp = adminService.updateEmp(emp);
		if (updateEmp != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewMang";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable long id, HttpSession session) {

		boolean f = adminService.deleteEmp(id);
		if (f) {
			session.setAttribute("succMsg", "Delete ucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewEmp";
	}

	@GetMapping("/deleteMang/{id}")
	public String deleteManager(@PathVariable long id, HttpSession session) {

		boolean f = adminService.deleteEmp(id);
		if (f) {
			session.setAttribute("succMsg", "Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewMang";
	}

	@PostMapping("/assignManager")
	public String assignManager(@ModelAttribute AssignManager as, HttpSession session) {

		if (adminService.assignManager(as) != null) {
			session.setAttribute("succMsg", "Manager Assign Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewAssMang";
	}

	@PostMapping("/updateHelplineStatus")
	public String updateHelplineStatus(@RequestParam("status") String status, @RequestParam("id") long id,
			HttpSession session) {

		if (adminService.updateHelpStatus(status, id) != null) {
			session.setAttribute("succMsg", "Status update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewQuery";
	}

	@GetMapping("uploadPayslip/{id}")
	public String uploadPayslip(@PathVariable long id, Model m) {
		m.addAttribute("e", adminService.getEmpById(id));
		return "admin/upload_payslip";
	}

	@GetMapping("viewPayslip")
	public String payslipEmp(Model m) {
		m.addAttribute("list", adminService.getAllEmp());
		return "admin/payslip";
	}

	@PostMapping("/savePayslip")
	public String savePlayslip(@ModelAttribute Payslip p, @RequestParam("payslip") MultipartFile file,
			HttpSession session) {

		p.setFileName(file.getOriginalFilename());

		if (adminService.uploadPayslip(p) != null) {

			try {
				File saveFile = new ClassPathResource("static/payslip").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				//System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}

			session.setAttribute("succMsg", "Payslip upload Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewPayslip";
	}

}
