package com.prog.service;


import java.util.List;

import com.prog.entites.Orders;

public interface OrderService {

	public List<Orders> saveOrder(List<Orders> list);

	public List<Orders> getByUser(int id);

	public List<Orders> getAllOrders();

	public Orders getOrderById(int id);
	
	public Orders updateOrders(Orders o);
}
