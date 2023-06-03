package com.railway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entites.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByEmail(String email);

	public UserDtls findByEmailAndMobNo(String email, String mob);
	
	
}
