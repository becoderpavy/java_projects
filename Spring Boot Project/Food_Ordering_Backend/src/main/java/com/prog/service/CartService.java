package com.prog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prog.entites.Cart;

public interface CartService {

	public Cart addCart(Cart cartDto);

	public boolean CheckCartByUser(Cart cartDto);

	public List<Cart> getAllCartByUser(HttpServletRequest request);

	public Cart updateQuantity(Integer id, Integer quntity);

	public void deleteCart(Integer id);

}
