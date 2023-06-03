package com.becoder.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.becoder.entites.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private Integer id;

	@NotEmpty
	@Size(min = 3, message = "username must be 4 charachter")
	private String name;

	@Email
	private String email;

	@NotEmpty
	@Size(min = 3, max = 10, message = "password must be 3 charcter or 10 max")
	/* @JsonIgnore */
	private String password;

	@NotEmpty
	private String about;

	// private List<PostDto> posts=new ArrayList<PostDto>();

	private Set<RoleDto> roles = new HashSet<RoleDto>();

}
