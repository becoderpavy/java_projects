package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental.config.CustomUserDetails;
import com.rental.entites.Role;
import com.rental.entites.UserDtls;
import com.rental.exception.ResourceNotFoundException;
import com.rental.jwt.JwtProvider;
import com.rental.repository.RoleRepository;
import com.rental.repository.UserRepository;
import com.rental.util.AppConstant;

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

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role role = roleRepo.findById(user.getRoleId())
				.orElseThrow(() -> new ResourceNotFoundException("Role", "invalid with id=", user.getRoleId()));

		user.getRole().add(role);

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
		
		UserDtls user=userRepo.findByEmailAndMobNo(email, mob);
		if(user!=null)
		{
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
