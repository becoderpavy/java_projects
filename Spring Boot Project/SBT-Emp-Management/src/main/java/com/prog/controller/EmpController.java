package com.prog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Emp;
import com.prog.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model m) {
		/*
		 * List<Emp> e = service.getAllEmp(); m.addAttribute("emplist", e);
		 */
		/* return "index"; */
		return FindPaginated(0, m);
	}

	@GetMapping("signup")
	public String addEmp(Model m) {
		Emp e = new Emp();
		m.addAttribute("emp", e);
		return "signup";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Emp e, HttpSession session) {
		session.setAttribute("msg", "Emp Added Sucessfully ");
		service.addEmp(e);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String getEMpById(@PathVariable int id, Model m) {
		System.out.println(id);
		Emp e = service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Emp e, HttpSession session) {
		session.setAttribute("msg", "Emp Update Sucessfully ");
		service.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {
		session.setAttribute("msg", "Emp Delete Sucessfully ");
		service.deleteEmpByID(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String FindPaginated(@PathVariable int pageNo, Model m) {

		Page<Emp> emp = service.getPageEmp(pageNo, 2);

		m.addAttribute("emplist", emp);
		m.addAttribute("currentPage", pageNo);
		m.addAttribute("totalPages", emp.getTotalPages());
		m.addAttribute("totalItem", emp.getTotalElements());

		return "index";
	}

}
