package com.ebook.service;

import java.util.List;

import com.ebook.entites.Cart;

public interface CartService {

	public Cart addCart(Cart cart);

	public List<Cart> getCartByUser(int userId);
	
	public boolean checkCartUser(int uid,int bid);
	
	public boolean deleteCart(int id);
	
	public long countCart(int uid);

}
