package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

	public List<Vehicle> findByCategory(String cat);
	
	public Vehicle findByRegistrationNumber(String regnum);
	
	
	

}
