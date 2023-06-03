package com.prog.service;


import com.prog.entites.User;

public interface UserService {

	User createUser(User user);

	User getUserById(int uid);

	User updateUser(User user);

	User chechUserEmailAndMobNo(String email, String mobno);

}
