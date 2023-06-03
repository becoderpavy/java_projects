package com.rental.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rental.dto.UserDto;
import com.rental.entites.User;

@Component
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;

	public User dtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	public UserDto userToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

}
