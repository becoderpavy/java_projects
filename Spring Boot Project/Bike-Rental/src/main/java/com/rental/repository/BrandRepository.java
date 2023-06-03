package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entites.Brands;

public interface BrandRepository extends JpaRepository<Brands,Integer>{

}
