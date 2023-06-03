package com.becoder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}
