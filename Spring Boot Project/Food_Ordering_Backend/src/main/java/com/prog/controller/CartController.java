package com.prog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog.entites.Cart;
import com.prog.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/")
	public ResponseEntity<?> createCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.CREATED);
	}

	@PostMapping("/check")
	public ResponseEntity<?> checkCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.CheckCartByUser(cart), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCartByUser(HttpServletRequest request) {
		return new ResponseEntity<>(cartService.getAllCartByUser(request), HttpStatus.OK);
	}

	@PostMapping("/updateQuan/{id}/{quantity}")
	public ResponseEntity<?> updateQuantity(@PathVariable Integer id, @PathVariable Integer quantity) {
		return new ResponseEntity<>(cartService.updateQuantity(id, quantity), HttpStatus.OK);
	}

	@GetMapping("/deleteCart/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable Integer id) {
		cartService.deleteCart(id);
		return new ResponseEntity<>("Item Removed", HttpStatus.OK);
	}

}
