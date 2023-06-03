package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Birth;

public interface BirthRepository extends JpaRepository<Birth, Long> {

	public List<Birth> findByUserId(long uid);

}
