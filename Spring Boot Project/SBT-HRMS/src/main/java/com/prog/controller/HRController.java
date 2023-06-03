package com.prog.controller;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.prog.entites.Project;
import com.prog.repository.EmpRepository;
import com.prog.service.AdminService;
import com.prog.service.EmpService;
import com.prog.service.ProjectService;

@Controller
@RequestMapping("/hr")
public class HRController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmpService empService;

	@Autowired
	private EmpRepository empRepo;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		Emp emp = empRepo.findByEmail(email);
		m.addAttribute("empx", emp);

	}

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("emp", adminService.countEmpByRole("ROLE_USER"));
		m.addAttribute("man", adminService.countEmpByRole("ROLE_MANAGER"));
		m.addAttribute("pro", projectService.countProject());
		return "hr/home";
	}

	@GetMapping("/addEmp")
	public String addEmp(Model m) {
		m.addAttribute("navName", "AddEmp");
		m.addAttribute("navlink", "addEmp");

		Long num = adminService.countEmp() + 1;
		m.addAttribute("empId", "EMPID" + num);

		return "hr/add_emp";
	}

	@GetMapping("/addSalaryForm")
	public String addSalaryForm(Model m) {
		m.addAttribute("navName", "Add Salary");
		m.addAttribute("navlink", "addSalaryForm");
		m.addAttribute("check", "no");
		return "hr/add_salary";
	}

	@GetMapping("/searchEmp")
	public String search(@RequestParam("empid") String empid, Model m, HttpSession session) {
		m.addAttribute("navName", "Add Salary");
		m.addAttribute("navlink", "addSalaryForm");

		Emp emp = empService.getByEmpId(empid);

		if (emp != null) {
			m.addAttribute("check", "yes");
			m.addAttribute("empxy", emp);
		} else {
			m.addAttribute("check", "no");
			session.setAttribute("errorMsg", "Emp Not Available");
		}

		return "hr/add_salary";
	}

	@PostMapping("/updateSalary")
	public String updateSalary(Model m, @RequestParam("id") long id, @RequestParam("salary") String salary,
			HttpSession session) {

		Emp emp = empRepo.findById(id).get();

		emp.setSalary(salary);
		empRepo.save(emp);

		m.addAttribute("check", "no");
		session.setAttribute("succMsg", "Update Sucessfully");
		return "hr/add_salary";
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

		return "redirect:/hr/addEmp";
	}

	@GetMapping("/viewEmp")
	public String viewEmp(Model m) {
		m.addAttribute("navName", "viewEmp");
		m.addAttribute("navlink", "viewEmp");
		List<Emp> list = adminService.getEmpByRoles("ROLE_USER");
		m.addAttribute("list", list);
		return "hr/view_emp";
	}

	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable long id, Model m) {
		m.addAttribute("navName", "editEmp");
		m.addAttribute("navlink", "editEmp/" + id);
		Emp emp = adminService.getEmpById(id);
		m.addAttribute("e", emp);
		return "hr/edit_emp";
	}

	@GetMapping("/addProject")
	public String addProject(Model m) {
		m.addAttribute("navName", "AddProjet");
		m.addAttribute("navlink", "addProject");
		m.addAttribute("manager", adminService.getEmpByRoles("ROLE_MANAGER"));
		return "hr/add_project";
	}

	@GetMapping("/viewProject")
	public String viewProject(Model m) {
		m.addAttribute("navName", "ViewProject");
		m.addAttribute("navlink", "viewProject");
		m.addAttribute("projectList", projectService.getAllProject());
		return "hr/view_project";
	}

	@GetMapping("/viewAssMang")
	public String viewAssignManag(Model m) {
		m.addAttribute("navName", "viewAssMang");
		m.addAttribute("navlink", "viewAssMang");
		m.addAttribute("list", adminService.getEmpByRoles("ROLE_USER"));
		m.addAttribute("adminService", adminService);
		return "hr/view_mang_assign";
	}

	@GetMapping("/assMang/{id}")
	public String AssignManag(@PathVariable long id, Model m) {
		m.addAttribute("navName", "assignManager");
		m.addAttribute("navlink", "assMang");
		m.addAttribute("e", adminService.getEmpById(id));
		m.addAttribute("manager", adminService.getEmpByRoles("ROLE_MANAGER"));
		return "hr/assign_manager";
	}

	@PostMapping("/assignManager")
	public String assignManager(@ModelAttribute AssignManager as, HttpSession session) {

		if (adminService.assignManager(as) != null) {
			session.setAttribute("succMsg", "Manager Assign Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewAssMang";
	}

	@GetMapping("/viewMang")
	public String viewMang(Model m) {
		m.addAttribute("navName", "viewMang");
		m.addAttribute("navlink", "viewMang");
		List<Emp> list = adminService.getEmpByRoles("ROLE_MANAGER");
		m.addAttribute("list", list);
		return "hr/view_mang";
	}

	@GetMapping("/editMang/{id}")
	public String editMang(@PathVariable long id, Model m) {
		m.addAttribute("navName", "editMang");
		m.addAttribute("navlink", "editMang/" + id);
		Emp emp = adminService.getEmpById(id);
		m.addAttribute("e", emp);
		return "hr/edit_mang";
	}

	@PostMapping("/updateManagerProfile")
	public String updateManagerEmp(@ModelAttribute Emp emp, HttpSession session) {

		Emp updateEmp = adminService.updateEmp(emp);
		if (updateEmp != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewMang";
	}

	@PostMapping("/updateProfile")
	public String updateEmp(@ModelAttribute Emp emp, HttpSession session) {

		Emp updateEmp = adminService.updateEmp(emp);
		if (updateEmp != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewEmp";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable long id, HttpSession session) {

		boolean f = adminService.deleteEmp(id);
		if (f) {
			session.setAttribute("succMsg", "Delete ucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewEmp";
	}

	@GetMapping("/deleteMang/{id}")
	public String deleteManager(@PathVariable long id, HttpSession session) {

		boolean f = adminService.deleteEmp(id);
		if (f) {
			session.setAttribute("succMsg", "Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewMang";
	}

	@GetMapping("/deleteProject/{id}")
	public String deletProject(@PathVariable int id, HttpSession session) {

		boolean f = projectService.deleteProject(id);
		if (f) {
			session.setAttribute("succMsg", "Delete Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewProject";
	}

	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute Project project, HttpSession session) {

		Project p = projectService.createProject(project);
		if (p != null) {
			session.setAttribute("succMsg", "update Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/viewProject";
	}

	@PostMapping("/createProject")
	public String createProject(@ModelAttribute Project project, HttpSession session) {

		Project p = projectService.createProject(project);
		if (p != null) {
			session.setAttribute("succMsg", "Added Sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/hr/addProject";
	}

	@GetMapping("/editProject/{id}")
	public String editProject(@PathVariable int id, Model m) {
		m.addAttribute("navName", "editProject");
		m.addAttribute("navlink", "editProject/" + id);
		m.addAttribute("p", projectService.getProjectById(id));
		m.addAttribute("manager", adminService.getEmpByRoles("ROLE_MANAGER"));
		return "hr/edit_project";
	}

	@GetMapping("/viewEmpDtls/{id}")
	public String viewProfile(@PathVariable long id, Model m) {
		m.addAttribute("navName", "viewEmpDtls");
		m.addAttribute("navlink", "viewEmpDtls/" + id);
		m.addAttribute("empdtls", adminService.getEmpById(id));
		return "hr/view_emp_dtls";
	}

	@GetMapping("/viewProfile")
	public String viewProfile() {
		return "hr/view_profile";
	}

	@GetMapping("/editProfile")
	public String editProfile() {
		return "hr/edit_profile";
	}

	@PostMapping("/profileUpdate")
	public String profileUpdate(@ModelAttribute Emp emp, HttpSession session) {

		if (empService.updateProfile(emp) != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}
		return "redirect:/hr/viewProfile";
	}

}
