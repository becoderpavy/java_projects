package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Cart;
import com.prog.entites.Food;
import com.prog.entites.UserDtls;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public boolean existsByFoodAndUser(Food food, UserDtls user);

	public List<Cart> findByUser(UserDtls user);

	public List<Cart> findByFood(Food fd);

}
