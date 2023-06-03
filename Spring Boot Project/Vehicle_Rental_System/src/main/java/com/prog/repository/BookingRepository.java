package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public List<Booking> findByCategory(String cat);
	
	
	
}
