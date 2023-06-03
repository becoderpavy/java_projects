package com.becoder.service;

import java.util.List;

import com.becoder.payloads.UserDto;

public interface UserService {
	
	UserDto registerUser(UserDto user);

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	void deleteUser(Integer userId);

}
