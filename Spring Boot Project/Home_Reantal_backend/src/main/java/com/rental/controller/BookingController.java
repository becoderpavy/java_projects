package com.rental.controller;

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

import com.rental.entites.Booking;
import com.rental.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

	@Autowired
	private BookingService bookService;

	@PostMapping("/")
	public ResponseEntity<?> createBooking(@RequestBody Booking booking, HttpServletRequest request) {
		
		return new ResponseEntity<>(bookService.createBooking(booking, request), HttpStatus.CREATED);
	}

	@GetMapping("/getByBuyer")
	public ResponseEntity<?> getBookingByBuyer(HttpServletRequest request) {
		return new ResponseEntity<>(bookService.getBookingByBuyer(request), HttpStatus.OK);
	}

	@GetMapping("/getBySeller")
	public ResponseEntity<?> getBookingBySeller(HttpServletRequest request) {
		return new ResponseEntity<>(bookService.getBookingBySeller(request), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllBooking(HttpServletRequest request) {
		return new ResponseEntity<>(bookService.getAllBooking(), HttpStatus.OK);
	}

	@GetMapping("/update/{bid}/{status}")
	public ResponseEntity<?> updateStatus(@PathVariable Integer bid, @PathVariable String status) {
		return new ResponseEntity<>(bookService.updateStatus(bid, status), HttpStatus.OK);
	}

}
