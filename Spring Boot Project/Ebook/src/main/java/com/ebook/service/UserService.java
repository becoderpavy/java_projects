package com.ebook.service;

import java.util.List;

import com.ebook.dto.UserDto;

public interface UserService {

	boolean checkEmail(String email);
	
	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(Integer id);
	
	UserDto updateUser(UserDto userDto,Integer id);
	
	UserDto signInWithUserReturnJwt(UserDto userDto);
	
	List<UserDto> getAllUser();
	
	
}
