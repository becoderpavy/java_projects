package com.prog.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prog.entity.Employee;
import com.prog.entity.User;
import com.prog.repository.UserRepo;
import com.prog.service.EmpService;

@Controller
@RequestMapping("/user")
public class EmpController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmpService service;

	@ModelAttribute
	public void addCommonData(Model m, Principal p) {
		String email = p.getName();
		// System.out.println(name);

		User u = userRepo.findByEmail(email);
		// System.out.println(u);

		m.addAttribute("user", u);
	}

	@GetMapping("/")
	public String home(Model m) {
		return findPaginated(0, m);
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "user/add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {

		service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/user/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {

		Employee e = service.getEMpById(id);

		m.addAttribute("emp", e);

		return "user/edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/user/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/user/";
	}

	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Employee> emplist = service.getEMpByPaginate(pageno, 5);
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());

		return "user/index";
	}

}
