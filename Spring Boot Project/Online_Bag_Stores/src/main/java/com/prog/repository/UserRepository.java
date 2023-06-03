package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findByEmailAndMobNo(String email, String mobNo);

}
