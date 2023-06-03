package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);

	public User findByEmail(String email);

}
