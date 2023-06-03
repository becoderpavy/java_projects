package com.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiring.entites.OrderBooking;

public interface OrderRepository extends JpaRepository<OrderBooking, Long> {

	public List<OrderBooking> findByUserId(long userId);

}
