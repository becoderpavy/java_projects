package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.entites.Jobs;
import com.portal.entites.User;
import com.portal.repository.JobRepository;
import com.portal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JobRepository jobRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setCompanyName("NA");
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public User updateProfile(User user) {
		User oldUser = userRepo.findById(user.getId()).get();
		user.setCompanyName("NA");
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());

		return userRepo.save(user);
	}

	@Override
	public Page<Jobs> getAllJob(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return jobRepo.findByStatusOrderByIdDesc(pageable, "Active");
	}

	@Override
	public Jobs getJobById(long id) {
		return jobRepo.findByIdAndStatus(id, "Active");
	}

	@Override
	public List<Jobs> searchJob(String cn, String lo) {
		return null;
	}

	@Override
	public boolean checkEmailAndMob(String email, String mobNo) {
		return userRepo.existsByEmailAndMobNo(email, mobNo);
	}

	@Override
	public User updatePassword(User user) {
		return userRepo.save(user);
	}

}
