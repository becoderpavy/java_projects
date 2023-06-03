package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByRoleOrderByIdDesc(String role);

	public boolean existsByEmail(String email);

	public User findByEmail(String email);

	public List<User> findByRoleAndCityOrderByIdDesc(String role, String city);

}
