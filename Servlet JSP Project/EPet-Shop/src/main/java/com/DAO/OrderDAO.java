package com.DAO;

import java.util.List;

import com.entity.OrderDtls;

public interface OrderDAO {

	public boolean addOrder(List<OrderDtls> o);
	
	public List<OrderDtls> getOrderForShop(int sid);
	
	public List<OrderDtls> getOrderForUser(int uid);
	
	
}
