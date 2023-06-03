package com.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.entites.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	public List<Vehicle> findByLocation(String location);
	
	public List<Vehicle> findByAvailability(String st);

}
