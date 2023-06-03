package com.ebook.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.dto.BookDto;
import com.ebook.dto.CartDto;
import com.ebook.entites.Books;
import com.ebook.entites.Cart;

@Component
public class CartMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Cart dtoToCart(CartDto cartDto) {
		return modelMapper.map(cartDto, Cart.class);
	}

	public CartDto cartToDto(Cart cart) {
		return this.modelMapper.map(cart, CartDto.class);
	}

}
