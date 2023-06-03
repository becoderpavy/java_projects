package com.ebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.entites.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	public List<Orders> findByUserId(int id);

}
