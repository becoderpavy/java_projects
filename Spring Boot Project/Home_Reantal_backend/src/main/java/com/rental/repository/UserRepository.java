package com.rental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entites.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByEmail(String email);

	public UserDtls findByEmailAndMobNo(String email, String mob);
	
	
}
