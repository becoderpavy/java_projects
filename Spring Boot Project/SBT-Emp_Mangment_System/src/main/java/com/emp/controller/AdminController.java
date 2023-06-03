package com.emp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.enties.Compliance;
import com.emp.enties.ComplianceStatus;
import com.emp.enties.Department;
import com.emp.enties.User;
import com.emp.service.AdminService;
import com.emp.service.ComplianceService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ComplianceService complianceService;

	@Autowired
	private BCryptPasswordEncoder bcode;

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
		m.addAttribute("list", adminService.getAllEmp());
		return "admin/view_emp";
	}

	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable long id, Model m) {
		m.addAttribute("e", adminService.getEmpById(id));
		return "admin/edit_emp";
	}

	@GetMapping("/addDepartment")
	public String addDepartment(Model m) {
		m.addAttribute("list", adminService.getAllDepartment());
		return "admin/add_depart";
	}

	@GetMapping("/editDepartment/{id}")
	public String editDepartment(@PathVariable long id, Model m) {
		m.addAttribute("d", adminService.getDepartmentById(id));
		return "admin/edit_depart";
	}

	@GetMapping("/departMap")
	public String departMap(Model m) {
		m.addAttribute("list", adminService.getAllEmp());
		return "admin/depart_map";
	}

	@GetMapping("/mapDepart/{name}/{id}")
	public String mapDepart(@PathVariable String name, @PathVariable long id, Model m) {

		m.addAttribute("name", name);
		m.addAttribute("id", id);
		m.addAttribute("list", adminService.getAllDepartment());

		return "admin/map_depart";
	}

	@PostMapping("/createEmp")
	public String addEmp(@ModelAttribute User user, HttpSession session) {

		if (!adminService.checkEmail(user.getEmail())) {
			user.setDepartment("NA");
			user.setPassword(bcode.encode(user.getPassword()));
			User us = adminService.addEmp(user);
			if (us != null) {
				session.setAttribute("succMsg", "Register Sucessfully");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}
		} else {
			session.setAttribute("errorMsg", "email id alreday exist");
		}
		return "redirect:/admin/addEmp";
	}

	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute User user, HttpSession session) {

		User us = adminService.addEmp(user);
		if (us != null) {
			session.setAttribute("succMsg", "Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/viewEmp";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable long id, HttpSession session) {

		if (adminService.deleteEmp(id)) {
			session.setAttribute("succMsg", "User Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/viewEmp";
	}

	@PostMapping("/createDepart")
	public String createDepartment(@ModelAttribute Department d, HttpSession session) {

		if (adminService.addDepartment(d) != null) {
			session.setAttribute("succMsg", "Department add Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/addDepartment";
	}

	@PostMapping("/updateDepart")
	public String updateDepart(@ModelAttribute Department d, HttpSession session) {

		if (adminService.addDepartment(d) != null) {
			session.setAttribute("succMsg", "Department Update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/addDepartment";
	}

	@GetMapping("/deleteDepart/{id}")
	public String deleteDepart(@PathVariable long id, HttpSession session) {

		if (adminService.deleteDepartment(id)) {
			session.setAttribute("succMsg", "Department Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/addDepartment";
	}

	@PostMapping("/updateDepartmentMap")
	public String updateDepartmentMap(@ModelAttribute User user, HttpSession session) {

		if (adminService.updateDepartmentMap(user.getDepartment(), user.getId()) != null) {
			session.setAttribute("succMsg", "Department Map Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/departMap";
	}

	@GetMapping("/compliance")
	public String compliance(Model m) {
		m.addAttribute("list", adminService.getAllDepartment());
		return "admin/compliance";
	}

	@GetMapping("/viewCompliance")
	public String view_compliance(Model m) {
		m.addAttribute("list", complianceService.getAllRL());
		return "admin/view_compliance";
	}

	@PostMapping("/createCompliance")
	public String createCompliance(@ModelAttribute Compliance com, HttpSession session) {

		if (complianceService.CreateRL(com) != null) {
			session.setAttribute("succMsg", "Compliance create Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/admin/compliance";
	}

	@GetMapping("/complianceStatus/{id}")
	public String complianceStatus(@PathVariable long id, Model m) {
		m.addAttribute("list", adminService.getAllEmp());
		m.addAttribute("com", complianceService.getRLById(id));
		return "admin/compliance_status";
	}

	@PostMapping("/complianceStatusUpdate")
	public String complianceStatusUpdate(@ModelAttribute ComplianceStatus comStatus, HttpSession session) {

		if (complianceService.statusUpdate(comStatus) != null) {
			session.setAttribute("succMsg", " Comments submit Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/complianceStatus/" + comStatus.getComplianceId();
	}

}
