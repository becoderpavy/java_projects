package com.prog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Contact;
import com.prog.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private ContactService contService;

	@PostMapping("/save")
	public ResponseEntity<?> createContact(@RequestBody Contact c, HttpServletRequest request) {

		if (contService.checkPhno(c.getPhone())) {
			return new ResponseEntity<>("Phone Number already exists", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(contService.createContact(c, request), HttpStatus.CREATED);
		}

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllContact(HttpServletRequest request) {
		return new ResponseEntity<>(contService.getUserByContact(request), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getContactById(@PathVariable Integer id) {
		return new ResponseEntity<>(contService.getContactById(id), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updpdateContact(@RequestBody Contact c, HttpServletRequest request) {
		return new ResponseEntity<>(contService.UpdateContact(c), HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable Integer id) {
		contService.deleteContact(id);
		return new ResponseEntity<>("Delete Sucessfully", HttpStatus.OK);
	}

}
