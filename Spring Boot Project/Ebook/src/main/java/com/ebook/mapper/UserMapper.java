package com.ebook.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.dto.UserDto;
import com.ebook.entites.User;

@Component
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;

	public User dtoToUser(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	public UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

}
