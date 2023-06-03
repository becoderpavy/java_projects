package com.realstate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.realstate.entites.User;
import com.realstate.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passencode;

	@Override
	public boolean checkEmail(String email) {

		return userRepository.existsByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(passencode.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User updateProfile(User u) {

		User oldUser = userRepository.findById(u.getId()).get();
		u.setPassword(oldUser.getPassword());
		u.setEmail(oldUser.getEmail());
		u.setRole(oldUser.getRole());
		return userRepository.save(u);
	}

}
