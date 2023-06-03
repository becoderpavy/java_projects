package com.railway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.railway.config.CustomUserDetails;
import com.railway.entites.UserDtls;
import com.railway.jwt.JwtProvider;
import com.railway.repository.UserRepository;
import com.railway.util.AppConstant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public UserDtls signInWithUserReturnJwt(UserDtls userDto) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

		CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();

		String token = jwtProvider.generateToken(customUser);

		UserDtls user = customUser.getUser();
		user.setToken(token);

		return user;
	}

	@Override
	public UserDtls checkEmailAndMob(String email, String mob) {

		UserDtls user = userRepo.findByEmailAndMobNo(email, mob);
		if (user != null) {
			return user;
		}

		return null;
	}

	@Override
	public UserDtls resetPassword(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
