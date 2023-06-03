package com.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.Role;
import com.portal.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByEmail(String email);

	public UserDtls findByEmailAndMobNo(String email, String mob);
	
	public List<UserDtls> findByRole(Role role);
	
}
