package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
