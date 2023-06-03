package com.prog.service;

import java.util.List;

import com.prog.entites.Booking;
import com.prog.entites.User;

public interface UserService {

	public User addUser(User user);

	public User updateUserProfile(User user);

	public boolean checkEmail(String email);

	public List<User> getAllElectrician(String role);

	public User getElectricianById(long id);
	
	public Booking book(Booking book);
	
	public List<Booking> getBookByUser(long userId);
	
	public List<Booking> getBookByElectrician(long electrcianId);
	
	public List<User> getElectricianBySearch(String role, String city);
}
