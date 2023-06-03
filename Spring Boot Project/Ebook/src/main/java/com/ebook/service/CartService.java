package com.ebook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ebook.dto.BookDto;
import com.ebook.dto.CartDto;
import com.ebook.dto.UserDto;

public interface CartService {

	public CartDto addCart(CartDto cartDto);

	public boolean CheckCartByUser(CartDto cartDto);

	public List<CartDto> getAllCartByUser(HttpServletRequest request);

	public CartDto updateQuantity(Integer id, Integer quntity);

	public void deleteCart(Integer id);

}
