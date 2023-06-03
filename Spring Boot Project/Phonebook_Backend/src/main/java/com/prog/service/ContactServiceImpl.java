package com.prog.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Contact;
import com.prog.entites.UserDtls;
import com.prog.exception.ResourceNotFoundException;
import com.prog.jwt.JwtProvider;
import com.prog.repository.ContactRepository;
import com.prog.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contRepo;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private FileService fileService;

	@Autowired
	private UserRepository userRepo;

	@Value("${project.image}")
	private String path;

	public int getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		return userId;
	}

	@Override
	public Contact createContact(Contact c, HttpServletRequest request) {

		int userId = getUserFromJwt(request);

		UserDtls user = userRepo.findById(userId).get();

		c.setUser(user);

		Contact con = contRepo.save(c);

		return con;
	}

	@Override
	public List<Contact> getUserByContact(HttpServletRequest request) {

		int userId = getUserFromJwt(request);

		UserDtls user = userRepo.findById(userId).get();

		List<Contact> list = contRepo.findByUser(user);

		return list;
	}

	@Override
	public Contact getContactById(Integer id) {
		return contRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("contact", "id", id));
	}

	@Override
	public Contact UpdateContact(Contact c) {
		Contact updateCont = contRepo.save(c);
		return updateCont;
	}

	@Override
	public void deleteContact(Integer id) {
		Contact con = contRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("contact", "id", id));
		if (con != null) {
			contRepo.delete(con);
		}
	}

	@Override
	public boolean checkPhno(String phno) {

		return contRepo.existsByPhone(phno);
	}

}
