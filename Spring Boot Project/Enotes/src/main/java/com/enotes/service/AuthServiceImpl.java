package com.enotes.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.enotes.config.CustomUserDetails;
import com.enotes.entites.Role;
import com.enotes.entites.UserDtls;
import com.enotes.exception.ResourceNotFoundException;
import com.enotes.jwt.JwtProvider;
import com.enotes.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private PasswordEncoder passwordEnocder;

	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public boolean checkUserName(String username) {
		return userRepository.existsByUserName(username);
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public UserDtls createUser(UserDtls user) {
		user.setCreateTime(LocalDateTime.now());
		user.setRole(Role.USER);
		user.setPassword(passwordEnocder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserDtls getUserById(int id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public Optional<UserDtls> findByUserNameOrEmail(String email, String username) {

		return userRepository.findByUserNameOrEmail(email, username);
	}

	@Override
	public UserDtls signinWIthUserReturnJWT(UserDtls u) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(u.getUserName(), u.getPassword()));

		CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
		String jwt = jwtProvider.generateToken(customUser);

		UserDtls loginUser = customUser.getUser();
		loginUser.setToken(jwt);

		return loginUser;
	}

}
