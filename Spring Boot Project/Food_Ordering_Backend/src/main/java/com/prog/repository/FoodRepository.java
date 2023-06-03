package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prog.entites.Category;
import com.prog.entites.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	public List<Food> findByCategory(Category cat);

	@Query("SELECT m FROM Food m WHERE m.title LIKE %:ch% or m.description LIKE %:ch% or m.status LIKE %:ch% and m.category=:cat ")
	public List<Food> searchFoodByCategory(String ch, Category cat);

}
