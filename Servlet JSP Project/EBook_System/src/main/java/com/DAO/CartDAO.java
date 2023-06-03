package com.DAO;

import java.util.List;

import com.entity.cart;

public interface CartDAO {
	
	public boolean addCart(cart c);
	
	public List<cart> getCartDetails(int uid);
	
	public boolean removeCart(int bid,int uid);
	
	public boolean cartCheck(int id);
	
	

}
