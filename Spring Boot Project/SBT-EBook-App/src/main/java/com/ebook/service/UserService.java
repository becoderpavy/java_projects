package com.ebook.service;

import com.ebook.entites.User;

public interface UserService {

	User createUser(User user);

	User getUserById(int uid);

	User updateUser(User user);

	User chechUserEmailAndMobNo(String email, String mobno);

}
