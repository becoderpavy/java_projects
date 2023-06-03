package com.ebook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ebook.dto.BookOrderDto;

public interface BookOrderService {

	public List<BookOrderDto> createOrder(HttpServletRequest request, String ptype);

	public List<BookOrderDto> getOrderByUser(HttpServletRequest request);

	public List<BookOrderDto> getAllOrder();

	public BookOrderDto updateOrder(Integer id, String st);

}
