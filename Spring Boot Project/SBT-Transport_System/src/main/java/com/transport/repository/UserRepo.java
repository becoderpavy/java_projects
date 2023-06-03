package com.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public boolean existsByUserName(String userName);

	public boolean existsByEmail(String email);

	public User findByEmail(String email);
	
	public User findByUserName(String userName);

}
