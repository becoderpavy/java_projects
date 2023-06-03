package com.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.entites.BookVehicle;

public interface BookVehicleRepo extends JpaRepository<BookVehicle, Integer> {

	public List<BookVehicle> findByUserName(String username);

	public List<BookVehicle> findByLocation(String loc);

}
