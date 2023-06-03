package com.rental.service;

import com.rental.dto.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDto);

	public boolean checkEmail(String email);

	public UserDto signInWithUserReturnJwt(UserDto userDto);

}
