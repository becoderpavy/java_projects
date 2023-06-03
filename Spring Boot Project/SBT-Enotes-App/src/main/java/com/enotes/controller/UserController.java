package com.enotes.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enotes.entity.Notes;
import com.enotes.entity.UserDtls;
import com.enotes.helper.Messgae;
import com.enotes.repository.NotesRepository;
import com.enotes.repository.UserRepository;
import com.enotes.service.NotesServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private NotesServiceImpl notesService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private NotesRepository notesRepo;

	@GetMapping("/add_notes")
	public String loadForm() {
		return "user/add_notes";
	}
	
	@ModelAttribute
	public void addCommonData(Model m, Principal p) {
		String email = p.getName();
		// System.out.println(name);

		UserDtls u = userRepo.findByEmail(email);
		// System.out.println(u);

		m.addAttribute("user", u);
	}
	
	

	@GetMapping("/view_notes/{page}")
	public String loadNotes(Principal p, Model m, @PathVariable int page) {

		String email = p.getName();
		UserDtls u = userRepo.findByEmail(email);

		Pageable pageable = PageRequest.of(page, 3, Sort.by("id").descending());
		Page<Notes> notes = notesRepo.findNotesByUser(u.getId(), pageable);

		m.addAttribute("pageNo", page);
		m.addAttribute("totalPage", notes.getTotalPages());
		m.addAttribute("Notes", notes);
		m.addAttribute("totalElement", notes.getTotalElements());

		return "user/view_notes";
	}

	@GetMapping("/editform/{nid}")
	public String loadEditForm(@PathVariable(value = "nid") long nid, Model m) {

		Optional<Notes> n = notesRepo.findById(nid);

		Notes notes = n.get();
		m.addAttribute("notes", notes);

		return "user/edit_notes";
	}

	@PostMapping("/save_notes")
	public String saveNotes(@ModelAttribute Notes n, HttpSession session, Principal p) {

		String email = p.getName();

		UserDtls u = userRepo.findByEmail(email);
		n.setUserDtls(u);

		if (notesService.saveNotes(n)) {
			session.setAttribute("message", new Messgae("Notes Added Sucessfully", "text-success"));
			return "redirect:/user/add_notes";
		} else {
			session.setAttribute("message", new Messgae("Something wrong on server", "text-danger"));
			return "redirect:/user/add_notes";
		}

	}

	@PostMapping("/update_notes")
	public String updateNotes(@ModelAttribute Notes n, HttpSession session, Principal p) {

		String email = p.getName();

		UserDtls u = userRepo.findByEmail(email);
		n.setUserDtls(u);

		if (notesService.saveNotes(n)) {
			session.setAttribute("message", new Messgae("Notes Update Sucessfully", "text-success"));
			return "redirect:/user/view_notes/0";
		} else {
			session.setAttribute("message", new Messgae("Something wrong on server", "text-danger"));
			return "redirect:/user/view_notes/0";
		}

	}

	@GetMapping("/deleteNotes/{id}")
	public String deleteNotes(@PathVariable long id, HttpSession session) {

		if (notesService.deleteNotes(id)) {
			session.setAttribute("message", new Messgae("Notes Delete Sucessfully", "text-success"));
			return "redirect:/user/view_notes/0";
		} else {
			session.setAttribute("message", new Messgae("Notes Update Sucessfully", "text-success"));
			return "redirect:/user/view_notes/0";
		}

	}

}
