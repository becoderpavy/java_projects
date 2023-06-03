package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prog.entites.Death;

public interface DeathRepository extends JpaRepository<Death, Long> {
	
	public List<Death> findByUserId(long uid);
}
