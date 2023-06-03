 package com.prog.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.ContactDtls;
import com.prog.entites.User;
import com.prog.helper.Message;
import com.prog.repo.ContactRepository;
import com.prog.repo.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private ContactRepository crepo;

	// method for addd common data to response
	@ModelAttribute
	public void addCommonData(Model m, Principal p) {
		String name = p.getName();
		// System.out.println(name);

		User u = repo.getUserByUserName(name);
		// System.out.println(u);

		m.addAttribute("user", u);
	}

	/// dashboard home
	@GetMapping("/index")
	public String dashboard(Model m, Principal p) {
		m.addAttribute("title", "User Dashboard");
		return "normal/user_dashboard";
	}

	// load contact form
	@GetMapping("/add_form")
	public String openAddForm(Model m) {
		m.addAttribute("title", "Add Contact");
		m.addAttribute("contact", new ContactDtls());
		return "normal/add_contact_form";
	}

	// contact save
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute ContactDtls contact, @RequestParam("imgName") MultipartFile file,
			Principal p, Model m, HttpSession session) {

		try {

			String name = p.getName();
			User u = this.repo.getUserByUserName(name);

			if (file.isEmpty()) {

				contact.setImgUrl("default.png");

			} else {
				contact.setImgUrl(file.getOriginalFilename());

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("image uploded");

			}

			contact.setUser(u);

			u.getContacts().add(contact);

			this.repo.save(u);

			// System.out.println("Add contact");

			session.setAttribute("message", new Message("Contact Added Sucessfully !! Add more..", "success"));

			// System.out.println(contact);
			m.addAttribute("contact", new ContactDtls());

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something wrong !! Try Again..", "danger"));
		}
		return "normal/add_contact_form";
	}

	@GetMapping("/show_contact/{page}")
	public String showContacts(Model m, Principal p, @PathVariable int page) {
		m.addAttribute("tittle", "Show User Contact");

		String email = p.getName();
		User u = repo.getUserByUserName(email);
		// List<ContactDtls> list=u.getContacts();

		Pageable pageable = PageRequest.of(page, 5);

		Page<ContactDtls> contatcs = this.crepo.findContactSByUser(u.getId(), pageable);
		m.addAttribute("contacts", contatcs);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", contatcs.getTotalPages());
		m.addAttribute("totalItem", contatcs.getTotalElements());

		return "normal/show_contact";
	}

	@GetMapping("/{id}/contact")
	public String viewContact(@PathVariable int id, Model m, Principal p) {

		Optional<ContactDtls> c = crepo.findById(id);
		ContactDtls contactDtls = c.get();

		String email = p.getName();
		User user = this.repo.getUserByUserName(email);

		if (user.getId() == contactDtls.getUser().getId()) {
			m.addAttribute("c", contactDtls);
			m.addAttribute("title", contactDtls.getName());
		}

		return "normal/contact_details";
	}

	@GetMapping("/delete/{id}")
	public String deleteContact(@PathVariable int id, Model m, Principal p, HttpSession session) {
		Optional<ContactDtls> contact = crepo.findById(id);
		ContactDtls c = contact.get();

		String email = p.getName();
		User u = repo.getUserByUserName(email);

		if (u.getId() == c.getUser().getId()) {
			crepo.delete(c);
			session.setAttribute("message", new Message("Contact Deleted Sucessfully", "success"));
		}

		return "redirect:/user/show_contact/0";
	}

//	Open update form handler

	@GetMapping("/update-contact/{cid}")
	public String openUpdateForm(@PathVariable int cid, Model m) {

		ContactDtls c = crepo.findById(cid).get();
		m.addAttribute("con", c);

		return "normal/update_form";
	}

	@PostMapping("/updateform")
	public String updateForm(@ModelAttribute ContactDtls c, @RequestParam("imgName") MultipartFile file,
			HttpSession session,Principal p) {
		
		try {
			
			//old contact details
			ContactDtls oldcontact=crepo.findById(c.getId()).get();
			
			if(!file.isEmpty())
			{
				//delete old photo
				File deletefile = new ClassPathResource("static/img").getFile();
				
				File f=new File(deletefile,oldcontact.getImgUrl());
				
				f.delete();
				
				
				
				//update new photo
				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				c.setImgUrl(file.getOriginalFilename());
			}
			else {
				c.setImgUrl(oldcontact.getImgUrl());
			}
			String un=p.getName();
			User u=repo.getUserByUserName(un);
			c.setUser(u);
			crepo.save(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(c);
		return "redirect:/user/"+c.getId()+"/contact";
	}
	
	//your profile
	@GetMapping("/profile")
	public String yourProfile()
	{
		return "normal/profile";
	}
	

}
