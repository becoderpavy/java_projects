package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
