package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prog.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT m FROM Category m WHERE m.categoryName LIKE %:ch% ")
	public List<Category> search(String ch);

}
