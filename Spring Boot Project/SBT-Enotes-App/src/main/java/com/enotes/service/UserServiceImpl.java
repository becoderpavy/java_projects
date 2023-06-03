package com.enotes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enotes.entity.UserDtls;
import com.enotes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean register(UserDtls user) {
		UserDtls u = userRepository.save(user);
		return u.getId() != null;
	}

	@Override
	public UserDtls getUserById(long id) {
		Optional<UserDtls> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public boolean checkEmail(String em) {
		UserDtls user = userRepository.findByEmail(em);
		return user.getId() != null;
	}

}
