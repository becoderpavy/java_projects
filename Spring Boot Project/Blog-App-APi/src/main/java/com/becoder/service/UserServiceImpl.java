package com.becoder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.becoder.entites.Role;
import com.becoder.entites.User;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.payloads.UserDto;
import com.becoder.repository.RoleRepository;
import com.becoder.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dtoToUser(userDto);
		User saveUser = userRepo.save(user);
		return userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		user.setId(userId);
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updateUser = userRepo.save(user);

		return userToDto(updateUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> list = userRepo.findAll();

		return list.stream().map(user -> userToDto(user)).collect(Collectors.toList());

	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		userRepo.delete(user);

	}

	private User dtoToUser(UserDto userDto) {

		/*
		 * User user = new User(); user.setId(userDto.getId());
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword()); user.setAbout(userDto.getAbout());
		 */

		User user = modelMapper.map(userDto, User.class);

		return user;
	}

	private UserDto userToDto(User user) {
		/*
		 * UserDto userDto = new UserDto(); userDto.setId(user.getId());
		 * userDto.setName(user.getName()); userDto.setEmail(user.getEmail());
		 * userDto.setPassword(user.getPassword()); userDto.setAbout(user.getAbout());
		 */

		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto registerUser(UserDto userdto) {
		User user=modelMapper.map(userdto, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Role role=roleRepo.findById(101).get();
		user.getRoles().add(role);
		User newUser=userRepo.save(user);
		
		return modelMapper.map(newUser, UserDto.class);
	}

}
