package com.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.entites.BookVehicle;
import com.transport.entites.Feedback;
import com.transport.entites.User;
import com.transport.repository.BookVehicleRepo;
import com.transport.repository.FeedbackRepo;
import com.transport.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BookVehicleRepo bookRepo;

	@Autowired
	private FeedbackRepo feedRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public boolean checkUserName(String userName) {
		return userRepo.existsByUserName(userName);
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User getUserById(int id) {

		return userRepo.findById(id).get();
	}

	@Override
	public boolean deleteUser(int id) {

		User user = userRepo.findById(id).get();
		if (user != null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public BookVehicle bookingVehicle(BookVehicle bk) {

		return bookRepo.save(bk);
	}

	@Override
	public List<BookVehicle> getBookingByUser(String userName) {
		return bookRepo.findByUserName(userName);
	}

	@Override
	public Feedback createFeedback(Feedback fe) {
		return feedRepo.save(fe);
	}

	@Override
	public List<Feedback> getFeedbackUserName(String username) {

		return feedRepo.findByUsername(username);
	}

	@Override
	public List<Feedback> getAllFeedback() {

		return feedRepo.findAll();
	}

	@Override
	public Feedback getFeedbackById(int id) {

		return feedRepo.findById(id).get();
	}

	@Override
	public List<BookVehicle> getBookingByLocation(String loc) {

		return bookRepo.findByLocation(loc);
	}

}
