package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entites.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByUserName(String username);

	
}
