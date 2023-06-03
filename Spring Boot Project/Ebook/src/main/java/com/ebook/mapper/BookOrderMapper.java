package com.ebook.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.dto.BookOrderDto;
import com.ebook.entites.BookOrder;

@Component
public class BookOrderMapper {
	@Autowired
	private ModelMapper modelMapper;

	public BookOrder dtoToBookOrder(BookOrderDto bookOrderDto) {
		return modelMapper.map(bookOrderDto, BookOrder.class);
	}

	public BookOrderDto bookOrderToDto(BookOrder bookOrder) {
		return modelMapper.map(bookOrder, BookOrderDto.class);
	}
}
