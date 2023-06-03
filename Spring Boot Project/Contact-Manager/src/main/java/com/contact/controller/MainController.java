package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contact.model.Contact;
import com.contact.model.dao.ContactDao;

@Controller
public class MainController {

	@Autowired
	private ContactDao dao;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/")
	public String homex(Model m) {
		List<Contact> list = dao.list();
		m.addAttribute("list", list);
		return "index";
	}
}
