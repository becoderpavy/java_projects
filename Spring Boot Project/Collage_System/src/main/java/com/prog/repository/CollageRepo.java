package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Collage;

public interface CollageRepo extends JpaRepository<Collage, Integer> {

	public Collage findByCollageName(String collageName);
	
	public boolean existsByCollageName(String collageName);

}
