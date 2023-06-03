package com.ebook.dto;

import java.util.HashSet;
import java.util.Set;

import com.ebook.entites.Role;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;

	private String name;

	private String email;

	private String password;

	private String mobNo;

	private String address;

	private String city;

	private String state;

	private String pincode;

	private Set<Role> role = new HashSet<Role>();
	
	private String token;
}
