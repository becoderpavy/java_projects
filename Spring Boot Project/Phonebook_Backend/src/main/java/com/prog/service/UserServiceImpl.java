package com.prog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.config.CustomUserDetails;
import com.prog.entites.Role;
import com.prog.entites.UserDtls;
import com.prog.exception.ResourceNotFoundException;
import com.prog.jwt.JwtProvider;
import com.prog.repository.RoleRepository;
import com.prog.repository.UserRepository;

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

		Role role = roleRepo.findById(102)
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
	
	@Override
	public void deleteUser(Integer id) {
		UserDtls user = userRepo.findById(id).get();

		if (user != null) {

//			for (Role r : user.getRole()) {
//				Role ro = roleRepo.findById(r.getId()).get();
//				roleRepo.delete(ro);
//			}

			userRepo.delete(user);
		}
	}

}
