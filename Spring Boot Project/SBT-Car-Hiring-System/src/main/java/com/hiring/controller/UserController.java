package com.hiring.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.User;
import com.hiring.entites.Vechicle;
import com.hiring.repository.OrderRepository;
import com.hiring.repository.UserRepository;
import com.hiring.service.UserService;
import com.hiring.service.VechicleService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VechicleService vechicleService;

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void addCommonData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		m.addAttribute("user", user);
	}

	@GetMapping("/home")
	public String home(Model m) {

		return "user/home";
	}

	@GetMapping("/vehicle/{type}")
	public String vehicle(@PathVariable(name = "type") String type, Model m) {

		List<Vechicle> list = vechicleService.getAllVechicleByType(type);
		m.addAttribute("vlist", list);
		m.addAttribute("vname", type);
		return "user/vehicle";
	}

	@GetMapping("/view_vehicle/{id}")
	public String getVehicle(@PathVariable long id, Model m) {

		Vechicle veh = vechicleService.getVehicleById(id);
		m.addAttribute("v", veh);

		return "user/view_vehicles";
	}

	@PostMapping("/bookData")
	public String calculateBookingPrice(@ModelAttribute OrderBooking order, Model m) {

		LocalDate dt = LocalDate.parse(order.getBookingDate());

		Period p = Period.between(LocalDate.parse(order.getBookingDate()), LocalDate.parse(order.getEndDate()));
		int days = p.getDays();

		Double totalAmount = vechicleService.calculateAmount(order);

		Vechicle veh = vechicleService.getVehicleById(order.getVehicleId());

		m.addAttribute("v", veh);
		m.addAttribute("totalAmount", totalAmount);
		m.addAttribute("atotalAmount", totalAmount + 60.0 + 30.0);
		m.addAttribute("d", order);

		return "user/payment";
	}

	@PostMapping("/orders")
	public String saveOrder(@ModelAttribute OrderBooking o, HttpSession session, Principal p) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);

		Vechicle v=vechicleService.getVehicleById(o.getVehicleId());
		
		o.setUserId(user.getId());
		o.setOrderId(new Random().nextInt(10000) + "");
		o.setVehicleName(v.getVehicleName());
		o.setUserName(user.getName());
		userService.saveOrder(o);
		
		return "user/book_success";
	}

	@GetMapping("/view_booking")
	public String view_booking(Model m,Principal p) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		List<OrderBooking> list = userService.getBookingByUser(user.getId());
		
		m.addAttribute("blist", list);
		
		return "user/view_booking";
	}

}
