package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.entites.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Long> {

	public List<Jobs> findByRecruiterIdOrderByIdDesc(long id);

	public Page<Jobs> findByStatusOrderByIdDesc(Pageable page, String status);

	public Jobs findByIdAndStatus(long id, String status);

	public List<Jobs> findByCompanyNameAndLocation(String cn, String lo);

	@Query("SELECT m FROM Jobs m WHERE m.companyName LIKE %:companyName% or m.location LIKE %:location% or m.category LIKE %:category% or m.title LIKE %:title%")
	List<Jobs> searchJob(String companyName, String location, String category, String title);
}
