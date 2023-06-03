package com.prog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.service.OrderService;


@RestController
@RequestMapping("/api/foodOrder")
public class FoodOrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{paymentType}")
	public ResponseEntity<?> createOrder(@PathVariable String paymentType, HttpServletRequest request) {
		return new ResponseEntity<>(orderService.createOrder(request, paymentType), HttpStatus.CREATED);
	}

	@GetMapping("/order")
	public ResponseEntity<?> getOrderByUser(HttpServletRequest request) {
		return new ResponseEntity<>(orderService.getOrderByUser(request), HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<?> getAllOrder(HttpServletRequest request) {
		return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
	}

	@GetMapping("/updateStatus/{id}/{st}")
	public ResponseEntity<?> updateOrder(@PathVariable Integer id, @PathVariable String st,
			HttpServletRequest request) {
		return new ResponseEntity<>(orderService.updateOrder(id, st), HttpStatus.OK);
	}

}
