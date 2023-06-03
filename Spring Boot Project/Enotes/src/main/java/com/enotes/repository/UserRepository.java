package com.enotes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enotes.entites.*;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByUserName(String username);

	public boolean existsByEmail(String email);

	public Optional<UserDtls> findByUserNameOrEmail(String email, String username);

}
