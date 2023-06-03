package com.ebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dto.BookDto;
import com.ebook.dto.CartDto;
import com.ebook.dto.UserDto;
import com.ebook.entites.Books;
import com.ebook.entites.Cart;
import com.ebook.entites.User;
import com.ebook.exception.ResourceNotFoundException;
import com.ebook.jwt.JwtProvider;
import com.ebook.mapper.BookMapper;
import com.ebook.mapper.CartMapper;
import com.ebook.mapper.UserMapper;
import com.ebook.repository.CartRepository;
import com.ebook.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private UserMapper userMapper;

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
	public CartDto addCart(CartDto cartDto) {

		return cartMapper.cartToDto(cartRepo.save(cartMapper.dtoToCart(cartDto)));
	}

	@Override
	public boolean CheckCartByUser(CartDto cartDto) {

		Books book = bookMapper.dtoToBook(cartDto.getBook());
		User user = userMapper.dtoToUser(cartDto.getUser());

		return cartRepo.existsByBookAndUser(book, user);
	}

	@Override
	public List<CartDto> getAllCartByUser(HttpServletRequest request) {

		int id = getUserId(request);

		User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		List<Cart> list = cartRepo.findByUser(user);
		Double tprice = 0.00;

		List<Cart> newList = new ArrayList<Cart>();

		for (Cart e : list) {
			tprice = tprice + e.getBook().getPrice() * e.getQuantity();
			e.setTotalPrice(tprice);
			newList.add(e);
		}

		return newList.stream().map((c) -> cartMapper.cartToDto(c)).collect(Collectors.toList());
	}

	@Override
	public CartDto updateQuantity(Integer id, Integer quantity) {

		Cart cart = cartRepo.findById(id).get();
		cart.setQuantity(quantity);

		Cart updateCart = cartRepo.save(cart);

		return cartMapper.cartToDto(updateCart);
	}

	@Override
	public void deleteCart(Integer id) {
		Cart cart = cartRepo.findById(id).get();
		cartRepo.delete(cart);
	}

}
