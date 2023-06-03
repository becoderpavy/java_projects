package com.prog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Cart;
import com.prog.entites.FoodOrders;
import com.prog.entites.UserDtls;
import com.prog.jwt.JwtProvider;
import com.prog.repository.FoodOrderRepository;
import com.prog.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private FoodOrderRepository foodOrderRepo;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CartService cartService;

	public int getUserId(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);
		return userId;
	}

	@Override
	public List<FoodOrders> createOrder(HttpServletRequest request, String ptype) {

		List<Cart> cartList = cartService.getAllCartByUser(request);

		List<FoodOrders> orderListDto = new ArrayList<FoodOrders>();

		FoodOrders foodOrder;
		Random random = new Random();

		for (Cart c : cartList) {
			foodOrder = new FoodOrders();
			foodOrder.setFood(c.getFood());
			foodOrder.setUser(c.getUser());
			foodOrder.setQuantity(c.getQuantity());
			foodOrder.setPaymentType(ptype);
			foodOrder.setOrderNumber("ORD-" + random.nextInt(1000));
			foodOrder.setDate(LocalDate.now());
			foodOrder.setStatus("Order Processing");
			orderListDto.add(foodOrder);
		}

		List<FoodOrders> orderSucess = foodOrderRepo.saveAll(orderListDto);

		return orderSucess;
	}

	@Override
	public List<FoodOrders> getOrderByUser(HttpServletRequest request) {

		int userId = getUserId(request);

		UserDtls user = userRepo.findById(userId).get();

		List<FoodOrders> list = foodOrderRepo.findByUser(user);

		return list;
	}

	@Override
	public List<FoodOrders> getAllOrder() {
		List<FoodOrders> list = foodOrderRepo.findAll();
		return list;
	}

	@Override
	public FoodOrders updateOrder(Integer id, String st) {

		FoodOrders fdOrd = foodOrderRepo.findById(id).get();
		fdOrd.setStatus(st);
		FoodOrders updtfdOrd = foodOrderRepo.save(fdOrd);
		return updtfdOrd;
	}

}
