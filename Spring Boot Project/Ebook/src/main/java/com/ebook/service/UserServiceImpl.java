package com.ebook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ebook.config.CustomUserDetails;
import com.ebook.dto.UserDto;
import com.ebook.entites.Role;
import com.ebook.entites.User;
import com.ebook.jwt.JwtProvider;
import com.ebook.mapper.UserMapper;
import com.ebook.repository.RoleRepository;
import com.ebook.repository.UserRepository;
import com.ebook.utils.AppConstant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = userMapper.dtoToUser(userDto);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		Role role = roleRepo.findById(AppConstant.USER_ID).get();
		user.getRole().add(role);

		return userMapper.userToDto(userRepo.save(user));
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDto signInWithUserReturnJwt(UserDto userDto) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

		CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();

		// System.out.println(customUser);

		String token = jwtProvider.generateToken(customUser);

		// System.out.println(token);

		User user = customUser.getUser();
		user.setToken(token);

		return userMapper.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list=userRepo.findAll();
		return  list.stream().map((e) -> userMapper.userToDto(e)).collect(Collectors.toList());
	}

}
