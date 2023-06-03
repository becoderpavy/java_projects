package com.enotes.service;

import com.enotes.entity.UserDtls;


public interface UserService {
	
	public boolean register(UserDtls user);
	
	public UserDtls getUserById(long id);
	
	public boolean checkEmail(String em);
	

}
