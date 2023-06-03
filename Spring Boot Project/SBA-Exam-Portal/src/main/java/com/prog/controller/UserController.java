package com.prog.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.model.Role;
import com.prog.model.User;
import com.prog.model.UserRole;
import com.prog.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public User createUser(@RequestBody User u) throws Exception
	{
		Set<UserRole> rolesSet=new HashSet<UserRole>();
		
		u.setProfile("default.png");
		Role r=new Role();
		r.setRoleId(45L);
		r.setRoleName("NORMAL");
		
		
		UserRole userRole=new UserRole();
		userRole.setUser(u);
		userRole.setRole(r);
		
		rolesSet.add(userRole);
		
		return this.service.CreateUser(u, rolesSet);
	}

}
