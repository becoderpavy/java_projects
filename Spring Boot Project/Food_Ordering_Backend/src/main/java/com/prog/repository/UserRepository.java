package com.prog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByEmail(String email);

	public UserDtls findByEmailAndMobNo(String email, String mob);
}
