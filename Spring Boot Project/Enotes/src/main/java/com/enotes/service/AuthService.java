package com.enotes.service;

import java.util.Optional;

import com.enotes.entites.*;

public interface AuthService {

	public boolean checkUserName(String username);

	public boolean checkEmail(String email);

	public UserDtls createUser(UserDtls user);

	public UserDtls getUserById(int id);

	public Optional<UserDtls> findByUserNameOrEmail(String email, String username);

	public UserDtls signinWIthUserReturnJWT(UserDtls u);

}
