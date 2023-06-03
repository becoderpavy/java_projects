package com.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	
}
