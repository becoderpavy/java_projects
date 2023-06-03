package com.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUserName(String userName);

}
