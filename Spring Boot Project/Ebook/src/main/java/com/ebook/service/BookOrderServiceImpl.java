package com.ebook.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dto.BookOrderDto;
import com.ebook.dto.CartDto;
import com.ebook.entites.BookOrder;
import com.ebook.entites.User;
import com.ebook.jwt.JwtProvider;
import com.ebook.mapper.BookOrderMapper;
import com.ebook.mapper.CartMapper;
import com.ebook.repository.BookOrderRepository;
import com.ebook.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class BookOrderServiceImpl implements BookOrderService {

	@Autowired
	private BookOrderRepository bookOrderRepo;

	@Autowired
	private BookOrderMapper bookOrderMapper;

	@Autowired
	private JwtProvider jwtProvide;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartMapper cartMapper;

	public int getUserId(HttpServletRequest request) {
		Claims claim = jwtProvide.extractClaims(request);
		int userId = claim.get("userId", Integer.class);
		return userId;
	}

	@Override
	public List<BookOrderDto> createOrder(HttpServletRequest request, String ptype) {

		List<CartDto> cartList = cartService.getAllCartByUser(request);

		List<BookOrderDto> orderListDto = new ArrayList<BookOrderDto>();

		BookOrderDto bookOrder;
		Random random = new Random();

		for (CartDto c : cartList) {
			bookOrder = new BookOrderDto();
			bookOrder.setBook(c.getBook());
			bookOrder.setUser(c.getUser());
			bookOrder.setQuantity(c.getQuantity());
			bookOrder.setPaymentType(ptype);
			bookOrder.setOrderNumber("ORD-" + random.nextInt(1000));
			bookOrder.setDate(LocalDate.now());
			bookOrder.setStatus("Order Processing");
			orderListDto.add(bookOrder);
		}

		List<BookOrder> orderList = orderListDto.stream().map((e) -> bookOrderMapper.dtoToBookOrder(e))
				.collect(Collectors.toList());

		List<BookOrder> orderSucess = bookOrderRepo.saveAll(orderList);

		return orderSucess.stream().map((e) -> bookOrderMapper.bookOrderToDto(e)).collect(Collectors.toList());
	}

	@Override
	public List<BookOrderDto> getOrderByUser(HttpServletRequest request) {

		int userId = getUserId(request);

		User user = userRepo.findById(userId).get();

		List<BookOrder> list = bookOrderRepo.findByUser(user);

		return list.stream().map((e) -> bookOrderMapper.bookOrderToDto(e)).collect(Collectors.toList());
	}

	@Override
	public List<BookOrderDto> getAllOrder() {
		List<BookOrder> list = bookOrderRepo.findAll();
		return list.stream().map((e) -> bookOrderMapper.bookOrderToDto(e)).collect(Collectors.toList());
	}

	@Override
	public BookOrderDto updateOrder(Integer id, String st) {

		BookOrder bkOrd = bookOrderRepo.findById(id).get();
		bkOrd.setStatus(st);
		BookOrder updtbkOrd = bookOrderRepo.save(bkOrd);
		return bookOrderMapper.bookOrderToDto(updtbkOrd);
	}

}
