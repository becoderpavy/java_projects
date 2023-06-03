package com.railway.service;

import com.railway.entites.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);

	UserDtls signInWithUserReturnJwt(UserDtls userDto);

	UserDtls checkEmailAndMob(String email, String mob);

	UserDtls resetPassword(UserDtls user);

}
