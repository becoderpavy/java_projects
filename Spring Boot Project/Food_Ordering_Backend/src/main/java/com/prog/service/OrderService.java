package com.prog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.prog.entites.FoodOrders;

public interface OrderService {

	public List<FoodOrders> createOrder(HttpServletRequest request, String ptype);

	public List<FoodOrders> getOrderByUser(HttpServletRequest request);

	public List<FoodOrders> getAllOrder();

	public FoodOrders updateOrder(Integer id, String st);

}
