package com.rental.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rental.entites.Booking;

public interface BookingService {

	public Booking createBooking(Booking booking,HttpServletRequest request);

	public List<Booking> getBookingByBuyer(HttpServletRequest request);

	public List<Booking> getBookingBySeller(HttpServletRequest request);

	public List<Booking> getAllBooking();

	public Booking updateStatus(Integer id, String status);

}
