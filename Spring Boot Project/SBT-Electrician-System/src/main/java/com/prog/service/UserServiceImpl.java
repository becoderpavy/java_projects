package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.entites.Booking;
import com.prog.entites.User;
import com.prog.repository.BookingRepository;
import com.prog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private BookingRepository bookRepo;

	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setSpecialization("NA");
		user.setExperience("NA");
		return userRepo.save(user);
	}

	@Override
	public User updateUserProfile(User user) {
		User oldUser = userRepo.findById(user.getId()).get();
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());
		user.setSpecialization("NA");
		user.setExperience("NA");
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	@Override
	public List<User> getAllElectrician(String role) {
		return userRepo.findByRoleOrderByIdDesc(role);
	}

	@Override
	public User getElectricianById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public Booking book(Booking book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Booking> getBookByUser(long userId) {
		return bookRepo.findByUserIdOrderByIdDesc(userId);
	}

	@Override
	public List<Booking> getBookByElectrician(long electrcianId) {
		return bookRepo.findByElectricianIdOrderByIdDesc(electrcianId);
	}

	@Override
	public List<User> getElectricianBySearch(String role, String city) {
		return userRepo.findByRoleAndCityOrderByIdDesc(role, city);
	}

}
