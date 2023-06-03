package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Marrige;

public interface MarriageRepository extends JpaRepository<Marrige, Long> {

	public List<Marrige> findByUserId(long uid);
}
