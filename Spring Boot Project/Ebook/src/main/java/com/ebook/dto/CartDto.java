package com.ebook.dto;

import lombok.Data;

@Data
public class CartDto {
	
	private Integer id;

	private BookDto book;

	private UserDto user;

	private Integer quantity;
	
	private Double totalPrice;
}
