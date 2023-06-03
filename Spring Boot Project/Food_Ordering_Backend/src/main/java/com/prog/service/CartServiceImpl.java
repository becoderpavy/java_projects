package com.prog.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Cart;
import com.prog.entites.UserDtls;
import com.prog.exception.ResourceNotFoundException;
import com.prog.jwt.JwtProvider;
import com.prog.repository.CartRepository;
import com.prog.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private JwtProvider jwtProvide;

	@Autowired
	private UserRepository userRepo;

	public int getUserId(HttpServletRequest request) {
		Claims claim = jwtProvide.extractClaims(request);
		int userId = claim.get("userId", Integer.class);
		return userId;
	}

	@Override
	public Cart addCart(Cart cart) {

		return cartRepo.save(cart);
	}

	@Override
	public boolean CheckCartByUser(Cart cart) {
		
		return cartRepo.existsByFoodAndUser(cart.getFood(), cart.getUser());
	}

	@Override
	public List<Cart> getAllCartByUser(HttpServletRequest request) {

		int id = getUserId(request);

		UserDtls user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		List<Cart> list = cartRepo.findByUser(user);
		Double tprice = 0.00;

		List<Cart> newList = new ArrayList<Cart>();

		for (Cart e : list) {
			tprice = tprice + e.getFood().getPrice() * e.getQuantity();
			e.setTotalPrice(tprice);
			newList.add(e);
		}

		return newList;
	}

	@Override
	public Cart updateQuantity(Integer id, Integer quantity) {

		Cart cart = cartRepo.findById(id).get();
		cart.setQuantity(quantity);

		Cart updateCart = cartRepo.save(cart);

		return updateCart;
	}

	@Override
	public void deleteCart(Integer id) {
		Cart cart = cartRepo.findById(id).get();
		cartRepo.delete(cart);
	}

}
