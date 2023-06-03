package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.AssignManager;

public interface AssignManagerRepository extends JpaRepository<AssignManager, Long> {

	public AssignManager findByUserId(long uid);

	public List<AssignManager> findByManagerId(long mid);

	public AssignManager findByUserIdAndManagerId(long uid, long mid);

	public boolean existsByUserId(long uid);

	
	
}
