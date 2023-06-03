package com.realstate.service;

import java.util.List;

import com.realstate.entites.Home;
import com.realstate.entites.User;

public interface AdminService {

	public Home AddHome(Home home);

	public List<Home> getAllHome();

	public Home getHomeById(long id);

	public boolean deleteHome(long id);

	public User updateUser(User user);

	public List<User> getAllUser();

	public User getUserById(long id);

	public boolean deleteUser(long id);
	
	public List<Home> getHomeBySearch(String city);

}
