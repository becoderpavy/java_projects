package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;

public interface JobRepository extends JpaRepository<Jobs, Integer> {

	public List<Jobs> findByRecruiter(UserDtls user);

	@Query("SELECT m FROM Jobs m WHERE m.title LIKE %:ch% or m.category LIKE %:ch% or m.location LIKE %:ch% or m.companyName LIKE  %:ch%")
	public List<Jobs> search(String ch);
}
