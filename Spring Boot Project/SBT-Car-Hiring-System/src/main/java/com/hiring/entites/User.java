package com.hiring.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phno;
	private String email;
	private String password;
	private String address;
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}

}
