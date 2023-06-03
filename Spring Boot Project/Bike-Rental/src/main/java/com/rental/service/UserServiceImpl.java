package com.rental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental.config.CustomUserDetails;
import com.rental.dto.UserDto;
import com.rental.entites.Role;
import com.rental.entites.User;
import com.rental.jwt.JwtProvider;
import com.rental.mapper.UserMapper;
import com.rental.repository.RoleRepository;
import com.rental.repository.UserRepository;
import com.rental.util.AppConstant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepoitory;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private AuthenticationManager authManager;

	@Override
	public UserDto createUser(UserDto userDto) {

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

		Role role = roleRepo.findById(AppConstant.ROLE_USER_ID).get();
		userDto.getRole().add(role);

		User user = userMapper.dtoToUser(userDto);

		return userMapper.userToDto(userRepoitory.save(user));
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepoitory.existsByEmail(email);
	}

	@Override
	public UserDto signInWithUserReturnJwt(UserDto userDto) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

		CustomUserDetails cutomUser = (CustomUserDetails) auth.getPrincipal();

		String token = jwtProvider.generateToken(cutomUser);

		User user = cutomUser.getUser();
		user.setToken(token);

		return userMapper.userToDto(user);
	}

}
