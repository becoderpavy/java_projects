package com.prog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Contact;

public interface ContactService {

	public Contact createContact(Contact c, HttpServletRequest request);

	public List<Contact> getUserByContact(HttpServletRequest request);

	public Contact getContactById(Integer id);

	public Contact UpdateContact(Contact c);

	public void deleteContact(Integer id);

	public boolean checkPhno(String phno);

}
