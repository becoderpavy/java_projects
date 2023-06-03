package com.hiring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.User;
import com.hiring.repository.OrderRepository;
import com.hiring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public boolean createUser(User user) {

		if (!userRepository.existsByEmail(user.getEmail())) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public OrderBooking saveOrder(OrderBooking o) {
		return orderRepository.save(o);
	}

	@Override
	public List<OrderBooking> getBookingByUser(long uid) {

		return orderRepository.findByUserId(uid);
	}
	
	@Override
	public List<OrderBooking> getAllBooking() {

		return orderRepository.findAll();
	}

}
