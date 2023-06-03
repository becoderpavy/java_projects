package com.prog.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Orders;
import com.prog.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<Orders> saveOrder(List<Orders> list) {
		return orderRepo.saveAll(list);
	}

	@Override
	public List<Orders> getByUser(int id) {

		return orderRepo.findByUserId(id);
	}

	@Override
	public List<Orders> getAllOrders() {

		return orderRepo.findAll();
	}

	@Override
	public Orders getOrderById(int id) {

		return orderRepo.findById(id).get();
	}

	@Override
	public Orders updateOrders(Orders o) {

		return orderRepo.save(o);
	}

}
