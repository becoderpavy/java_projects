package com.DAO;

import java.util.List;

import com.entity.orderDtls;

public interface OrderDAO {
	public boolean orderSave(List<orderDtls> order);

	public List<orderDtls> getOrder(String email);
	
	public List<orderDtls> getAllOrder();
	
	public int getTotalOrderNo();
	
}
