package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Long>{

	public UserDtls findByEmail(String email);
	
	public boolean existsByEmail(String emaail);
	
	public List<UserDtls>  findByFirstNameOrLastNameContains(String fn,String ln);
	
	
}
