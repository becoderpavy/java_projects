package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prog.entites.Bag;

public interface BagRepository extends JpaRepository<Bag, Integer> {

	@Query("SELECT s FROM Bag s ORDER BY s.id DESC")
	List<Bag> findOrderByIddesc();

	List<Bag> findByCategortId(int id);

	@Query("SELECT m FROM Bag m WHERE m.title LIKE %:title%")
	List<Bag> findByBookNameSearch(String title);

}
