package com.rental.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.entites.Booking;
import com.rental.entites.Home;
import com.rental.entites.UserDtls;
import com.rental.exception.ResourceNotFoundException;
import com.rental.jwt.JwtProvider;
import com.rental.repository.BookingRepository;
import com.rental.repository.HomeRepository;
import com.rental.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private HomeRepository homeRepo;

	@Autowired
	private JwtProvider jwtProvider;

	public int getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		return userId;
	}

	@Override
	public Booking createBooking(Booking booking, HttpServletRequest request) {

		int uid = getUserFromJwt(request);
		UserDtls buyer = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token is invalid with", uid));

		Random rand = new Random();

		booking.setStatus("Booking Pending");
		booking.setBookingDate(LocalDate.now().toString());
		booking.setBookingId("BID" + rand.nextInt(1000) + "");
		booking.setBuyer(buyer);

		Booking book = bookingRepo.save(booking);

		return book;
	}

	@Override
	public List<Booking> getBookingByBuyer(HttpServletRequest request) {
		int uid = getUserFromJwt(request);
		UserDtls user = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token is invalid with", uid));
		return bookingRepo.findByBuyer(user);
	}

	@Override
	public List<Booking> getBookingBySeller(HttpServletRequest request) {
		int uid = getUserFromJwt(request);
		UserDtls user = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token is invalid with", uid));
		return bookingRepo.findBySeller(user);
	}

	@Override
	public List<Booking> getAllBooking() {

		return bookingRepo.findAll();
	}

	@Override
	public Booking updateStatus(Integer id, String status) {

		Booking b = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
		b.setStatus(status);
		
		Booking updateBook=bookingRepo.save(b);
		
		Home h=homeRepo.findById(b.getHome().getId()).get();
		
		if(updateBook!=null)
		{
			if("Confirmed".equals(b.getStatus()) || "Check in".equals(b.getStatus()))
			{
				h.setStatus("Booked");
				
			}else {
				h.setStatus("Available");
			}
			
			homeRepo.save(h);
		}
		
		return updateBook;
	}

}
