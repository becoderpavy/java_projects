package com.transport.service;

import java.util.List;

import com.transport.entites.BookVehicle;
import com.transport.entites.Feedback;
import com.transport.entites.User;

public interface UserService {

	public User createUser(User user);

	public List<User> getAllUser();

	public boolean checkUserName(String userName);

	public boolean checkEmail(String email);

	public User getUserById(int id);

	public boolean deleteUser(int id);

	public BookVehicle bookingVehicle(BookVehicle bk);

	public List<BookVehicle> getBookingByUser(String userName);

	public List<BookVehicle> getBookingByLocation(String loc);

	public Feedback createFeedback(Feedback fe);

	public List<Feedback> getFeedbackUserName(String username);

	public List<Feedback> getAllFeedback();

	public Feedback getFeedbackById(int id);

}
