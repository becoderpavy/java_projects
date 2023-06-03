package com.realstate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realstate.entites.Home;
import com.realstate.entites.User;
import com.realstate.repository.HomeRepository;
import com.realstate.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HomeRepository homeRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Home AddHome(Home home) {
		return homeRepo.save(home);
	}

	@Override
	public List<Home> getAllHome() {
		return homeRepo.findAllByOrderByIdDesc();
	}

	@Override
	public Home getHomeById(long id) {

		return homeRepo.findById(id).get();
	}

	@Override
	public boolean deleteHome(long id) {
		Home h = homeRepo.findById(id).get();
		if (h != null) {
			homeRepo.delete(h);
			return true;
		}
		return false;
	}

	@Override
	public User updateUser(User user) {

		User oldUser = userRepo.findById(user.getId()).get();

		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());

		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public boolean deleteUser(long id) {
		User u = userRepo.findById(id).get();
		if (u != null) {
			userRepo.delete(u);
			return true;
		}
		return false;
	}

	@Override
	public List<Home> getHomeBySearch(String city) {

		return homeRepo.findByCityOrderByIdDesc(city);
	}

}
