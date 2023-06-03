package com.ebook.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.dto.BookDto;
import com.ebook.entites.Books;

@Component
public class BookMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Books dtoToBook(BookDto bookDto) {
		return modelMapper.map(bookDto, Books.class);
	}

	public BookDto bookToDto(Books books) {
		return this.modelMapper.map(books, BookDto.class);
	}

}
