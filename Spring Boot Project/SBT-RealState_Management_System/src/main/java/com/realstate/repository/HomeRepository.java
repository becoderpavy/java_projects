package com.realstate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realstate.entites.Home;

public interface HomeRepository extends JpaRepository<Home, Long> {

	public List<Home> findAllByOrderByIdDesc();

	public List<Home> findByCityOrderByIdDesc(String city);

}
