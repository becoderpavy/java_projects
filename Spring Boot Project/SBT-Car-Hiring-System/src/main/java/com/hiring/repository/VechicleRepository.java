package com.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiring.entites.Vechicle;

public interface VechicleRepository extends JpaRepository<Vechicle, Long>{

	public List<Vechicle> findByVehicleType(String v);

}
