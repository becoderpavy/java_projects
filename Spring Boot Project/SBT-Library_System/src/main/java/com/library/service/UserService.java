package com.library.service;

import com.library.entites.User;

public interface UserService {

	User createUser(User user);

	User getUserById(int uid);

	User updateUser(User user);

	User chechUserEmailAndMobNo(String email, String mobno);

	public boolean deleteUser(int id);
	
	
}
