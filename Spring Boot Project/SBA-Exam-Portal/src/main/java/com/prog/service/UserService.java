package com.prog.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.prog.model.User;
import com.prog.model.UserRole;

@Service
public interface UserService {
	
	public User CreateUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public User getUser();
	

}
