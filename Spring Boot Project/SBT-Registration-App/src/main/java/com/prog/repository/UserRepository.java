package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public UserDtls findByEmail(String em);
	
}
