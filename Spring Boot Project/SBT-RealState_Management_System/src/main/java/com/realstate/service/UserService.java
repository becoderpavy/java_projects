package com.realstate.service;

import com.realstate.entites.User;

public interface UserService {

	public boolean checkEmail(String email);

	public User saveUser(User user);
	
	public User updateProfile(User u);

}
