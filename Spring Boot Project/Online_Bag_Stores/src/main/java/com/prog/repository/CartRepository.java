package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByUserId(int id);

	public boolean existsByUserIdAndBookId(int uid, int bid);

	public long countByUserId(int uid);

}
