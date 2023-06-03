package com.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entites.Booking;
import com.rental.entites.UserDtls;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public List<Booking> findByBuyer(UserDtls user);

	public List<Booking> findBySeller(UserDtls user);

}
