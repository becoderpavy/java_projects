package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entites.LibraryDtls;
import com.library.entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findByEmailAndMobNo(String email, String mobNo);
	
	public List<User> findByLibrary(LibraryDtls lib);
	
	public boolean existsByEmail(String email);
	
	public boolean existsByMobNo(String mob);

}
