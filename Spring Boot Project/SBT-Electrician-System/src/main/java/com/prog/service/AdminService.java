package com.prog.service;

import java.util.List;

import com.prog.entites.User;

public interface AdminService {

	public User addEletrician(User user);

	public List<User> getAllElectrician(String role);

	public User getELectrician(long id);

	public User updateElectrician(User user);

	public boolean deleteElectrician(long id);

	public boolean checkEmail(String email);

}
