package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.entites.User;
import com.library.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(int uid) {

		return userRepository.findById(uid).get();
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User chechUserEmailAndMobNo(String email, String mobno) {

		return userRepository.findByEmailAndMobNo(email, mobno);
	}

	@Override
	public boolean deleteUser(int id) {
		User u = userRepository.findById(id).get();
		if (u != null) {
			userRepository.delete(u);
			return true;
		}
		return false;
	}

}
