package com.enotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Long> {
	
	public UserDtls findByEmail(String em);
	
	boolean existsByEmail(String email);

}
