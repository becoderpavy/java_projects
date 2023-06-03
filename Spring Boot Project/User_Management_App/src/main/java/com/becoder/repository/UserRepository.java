package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public UserDtls findByEmail(String email);

	public UserDtls findByEmailAndMobileNumber(String email, String mobileNum);
	
	
	public UserDtls findByVerificationCode(String code);
	
}
