package com.enotes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.entites.Notes;
import com.enotes.service.NotesService;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@PostMapping("/save")
	public ResponseEntity<?> saveNotes(@RequestBody Notes n, HttpServletRequest request) {

		return new ResponseEntity<>(notesService.addNotes(n, request), HttpStatus.CREATED);
	}

	@GetMapping("/getAllNotes")
	public ResponseEntity<?> getAllNotes(HttpServletRequest request) {
		return new ResponseEntity<>(notesService.getAllNotes(request), HttpStatus.OK);
	}

	@GetMapping("/deleteNotes/{id}")
	public ResponseEntity<?> deleteNotes(@PathVariable int id) {
		notesService.deleteNotes(id);
		return new ResponseEntity<>("Delete Sucessfully", HttpStatus.OK);
	}

	@PostMapping("/updateNotes/{id}")
	public ResponseEntity<?> updateNotes(@PathVariable int id, @RequestBody Notes n, HttpServletRequest request) {
		return new ResponseEntity<>(notesService.updateNotes(id, n, request), HttpStatus.OK);
	}
	
	@GetMapping("/getNote/{id}")
	public ResponseEntity<?> getNotesById(@PathVariable int id, HttpServletRequest request) {
		return new ResponseEntity<>(notesService.getNotesById(id, request), HttpStatus.OK);
	}
	
	

}
