package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.ProjectStatus;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long>{

	
	public List<ProjectStatus> findByManagerIdAndUserIdOrderByIdDesc(long mid,long uid);
	
}
