package com.prog.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Food;
import com.prog.entites.UserDtls;

public interface FoodService {

	public Food createFood(Food food, MultipartFile file);

	public Food getFoodById(Integer id);

	public List<Food> getAllFood();

	public void deleteFood(Integer Id);

	public List<Food> getFoodByCategory(Integer categoryId);

	public Food updateFood(Food food,MultipartFile file);
	
	UserDtls updateProfile(UserDtls user);

	public List<Food> searchFoodByCategory(String ch, Integer id);
	
	public List<UserDtls> getAllUser();

}
