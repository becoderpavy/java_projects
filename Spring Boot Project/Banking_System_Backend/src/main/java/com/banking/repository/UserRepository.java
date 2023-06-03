package com.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByEmail(String email);

	public UserDtls findByEmailAndMobNo(String email, String mob);

	public List<UserDtls> findByRoleAndAccStatus(String role, String st);

	public UserDtls findByAccountNum(String accountNum);

	public boolean existsByUsername(String username);

	public Optional<UserDtls> findByUsername(String username);
}
