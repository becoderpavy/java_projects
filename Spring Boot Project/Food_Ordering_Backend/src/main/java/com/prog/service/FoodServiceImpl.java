package com.prog.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prog.entites.Cart;
import com.prog.entites.Category;
import com.prog.entites.Food;
import com.prog.entites.FoodOrders;
import com.prog.entites.UserDtls;
import com.prog.exception.ResourceNotFoundException;
import com.prog.repository.CartRepository;
import com.prog.repository.CategoryRepository;
import com.prog.repository.FoodOrderRepository;
import com.prog.repository.FoodRepository;
import com.prog.repository.UserRepository;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private FileService fileService;

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private FoodOrderRepository foodOrderRepo;

	@Value("${project.image}")
	private String path;

	@Override
	public Food createFood(Food food, MultipartFile file) {

		Category ca = catRepo.findById(food.getCategoryId()).get();
		food.setCategory(ca);
		if (file.isEmpty()) {
			food.setImage("default.jpg");
		} else {
			food.setImage(file.getOriginalFilename());
		}

		Food fd = foodRepo.save(food);
		if (fd != null) {
			if (!file.isEmpty()) {
				try {
					fileService.uploadImage(path, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return fd;
	}

	@Override
	public Food getFoodById(Integer id) {
		Food food = foodRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "Id", id));
		return food;
	}

	@Override
	public List<Food> getAllFood() {
		return foodRepo.findAll();
	}

	@Override
	public void deleteFood(Integer id) {
		Food food = foodRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "Id", id));
		
		List<FoodOrders> fdOrd = foodOrderRepo.findByFood(food);
		List<Cart> cart = cartRepo.findByFood(food);

		if (!fdOrd.isEmpty()) {
			
			for (FoodOrders fd : fdOrd) {
				
				foodOrderRepo.deleteById(fd.getId());
			}
		}

		if (cart != null) {
			for (Cart c : cart) {
				cartRepo.deleteById(c.getId());
			}
		}

		if (food != null) {
			foodRepo.delete(food);
		}
	}

	@Override
	public List<Food> getFoodByCategory(Integer categoryId) {

		Category ca = catRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		return foodRepo.findByCategory(ca);
	}

	@Override
	public Food updateFood(Food food, MultipartFile file) {
		Food fd = foodRepo.findById(food.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Food", "Id", food.getId()));

		Category ca = catRepo.findById(food.getCategoryId()).get();
		food.setCategory(ca);

		if (file.isEmpty()) {
			food.setImage(fd.getImage());
		} else {
			food.setImage(file.getOriginalFilename());
		}

		Food updateFood = foodRepo.save(food);

		if (updateFood != null) {
			if (!file.isEmpty()) {
				try {
					fileService.uploadImage(path, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return updateFood;
	}

	@Override
	public UserDtls updateProfile(UserDtls user) {
		return userRepo.save(user);
	}

	@Override
	public List<Food> searchFoodByCategory(String ch, Integer id) {

		Category cat = catRepo.findById(id).get();

		return foodRepo.searchFoodByCategory(ch, cat);
	}

	@Override
	public List<UserDtls> getAllUser() {

		return userRepo.findAll();
	}

}
