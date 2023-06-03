package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
