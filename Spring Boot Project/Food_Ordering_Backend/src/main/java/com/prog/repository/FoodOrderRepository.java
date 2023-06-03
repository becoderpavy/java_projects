package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Food;
import com.prog.entites.FoodOrders;
import com.prog.entites.UserDtls;

public interface FoodOrderRepository extends JpaRepository<FoodOrders, Integer> {

	public List<FoodOrders> findByUser(UserDtls user);

	public List<FoodOrders> findByFood(Food fd);

}
