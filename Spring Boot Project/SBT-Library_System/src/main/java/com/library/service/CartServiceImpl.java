package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entites.Cart;
import com.library.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {

		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> getCartByUser(int userId) {

		return cartRepository.findByUserId(userId);
	}

	@Override
	public boolean checkCartUser(int uid, int bid) {

		return cartRepository.existsByUserIdAndBookId(uid, bid);
	}

	@Override
	public boolean deleteCart(int id) {
		Cart c = cartRepository.findById(id).get();
		if (c != null) {
			cartRepository.delete(c);
			return true;
		}
		return false;
	}

	@Override
	public long countCart(int uid) {
		return cartRepository.countByUserId(uid);
	}

}
