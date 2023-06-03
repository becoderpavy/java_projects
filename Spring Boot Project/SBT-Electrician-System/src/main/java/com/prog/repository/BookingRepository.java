package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	public List<Booking> findByUserIdOrderByIdDesc(long id);
	
	public List<Booking> findByElectricianIdOrderByIdDesc(long id);

}
