package com.library.service;

import java.util.List;

import com.library.entites.LibraryDtls;
import com.library.entites.Orders;

public interface OrderService {

	public List<Orders> saveOrder(List<Orders> list);

	public List<Orders> getByUser(int id);

	public List<Orders> getAllOrdersByLibraian(LibraryDtls libDtls);

	public Orders getOrderById(int id);
	
	public Orders updateOrders(Orders o);
}
