package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.entites.User;
import com.prog.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User addEletrician(User user) {
		user.setRole("ROLE_ELECTRICIAN");
		user.setPassword(passwordEncode.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllElectrician(String role) {
		return userRepo.findByRoleOrderByIdDesc(role);
	}

	@Override
	public User getELectrician(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User updateElectrician(User user) {

		User oldUser = userRepo.findById(user.getId()).get();
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());
		return userRepo.save(user);
	}

	@Override
	public boolean deleteElectrician(long id) {
		User user = userRepo.findById(id).get();
		if (user != null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

}
