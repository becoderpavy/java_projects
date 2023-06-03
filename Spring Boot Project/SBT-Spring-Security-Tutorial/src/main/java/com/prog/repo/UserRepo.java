package com.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.models.User;

public interface UserRepo extends JpaRepository<User, String> {

	public User findByUserName(String username);

}
