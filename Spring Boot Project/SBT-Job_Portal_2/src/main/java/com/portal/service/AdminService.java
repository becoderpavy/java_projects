package com.portal.service;

import java.util.List;

import com.portal.entites.User;

public interface AdminService {

	public boolean checkEmail(String email);

	public User createUser(User user);

	public List<User> getAllUser(String role);

	public User getUserById(long id);

	public User updateUser(User user);
	
	public boolean deleteUser(long id);

}
