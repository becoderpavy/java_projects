package com.hiring.service;

import java.util.List;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.User;

public interface UserService {

	boolean createUser(User user);

	public OrderBooking saveOrder(OrderBooking o);

	public List<OrderBooking> getBookingByUser(long uid);
	
	public List<OrderBooking> getAllBooking();

}
