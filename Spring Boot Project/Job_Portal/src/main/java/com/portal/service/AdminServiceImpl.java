package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.entites.User;
import com.portal.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setPrimarySkill("NA");
		user.setExperience("NA");
		/* user.setRole("ROLE_RECRUITER"); */

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser(String role) {

		return userRepo.findByRoleOrderByIdDesc(role);
	}

	@Override
	public User getUserById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		User oldUser = userRepo.findById(user.getId()).get();
		user.setPrimarySkill("NA");
		user.setExperience("NA");
		user.setRole("ROLE_RECRUITER");
		user.setPassword(oldUser.getPassword());
		return userRepo.save(user);
	}

	@Override
	public boolean deleteUser(long id) {
		User user = userRepo.findById(id).get();
		if (user != null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}

}
