package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entites.Jobs;

public interface JobRepository extends JpaRepository<Jobs, Long> {

	public List<Jobs> findByRecruiterIdOrderByIdDesc(long id);

	public Page<Jobs> findByStatusOrderByIdDesc(Pageable page, String status);

	public Jobs findByIdAndStatus(long id, String status);

	public List<Jobs> findByCompanyNameAndLocation(String cn, String lo);

	/*
	 * public List<Jobs> findByCompanyNameContainingAndLocation(String
	 * companyName,String location);
	 */

}
