package com.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rental.entites.Home;
import com.rental.entites.UserDtls;

public interface HomeRepository extends JpaRepository<Home, Integer> {

	public List<Home> findBySeller(UserDtls user);
	
	@Query("SELECT m FROM Home m WHERE m.title LIKE %:ch% or m.status LIKE %:ch% or m.location LIKE %:ch% ")
	public List<Home> search(String ch);

}
