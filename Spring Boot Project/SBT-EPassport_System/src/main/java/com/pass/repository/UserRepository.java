package com.pass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pass.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);

	public User findByEmail(String email);

}
