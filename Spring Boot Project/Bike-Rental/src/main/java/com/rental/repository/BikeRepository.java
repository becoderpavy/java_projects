package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entites.Bikes;

public interface BikeRepository extends JpaRepository<Bikes, Integer> {

	public boolean existsByBikeNo(String bikeNo);

}
