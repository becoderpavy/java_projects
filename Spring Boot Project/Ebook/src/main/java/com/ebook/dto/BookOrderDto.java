package com.ebook.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookOrderDto {

	private Integer id;

	private UserDto user;

	private BookDto book;

	private int quantity;

	private String paymentType;
	
	private String orderNumber;
	
	private LocalDate date;
	
	private String status;
}
