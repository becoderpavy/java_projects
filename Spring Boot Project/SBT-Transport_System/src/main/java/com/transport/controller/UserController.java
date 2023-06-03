package com.transport.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.entites.BookVehicle;
import com.transport.entites.Feedback;
import com.transport.entites.User;
import com.transport.entites.Vehicle;
import com.transport.repository.UserRepo;
import com.transport.service.UserService;
import com.transport.service.VehicleService;

@Controller
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		// System.out.println(user);
		m.addAttribute("user", user);
	}

	@GetMapping("/")
	public String home(Model m) {
		return "index";
	}

	@GetMapping("/booking")
	public String booking(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("list", userService.getBookingByUser(user.getUserName()));
		return "user/booking";
	}

	@GetMapping("/contact")
	public String contact(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("list", userService.getFeedbackUserName(user.getUserName()));
		return "user/contact";
	}

	@GetMapping("/service/{id}")
	public String service(Model m, @PathVariable int id) {
		m.addAttribute("veh", vehicleService.getVehicleById(id));
		return "user/service";
	}

	@GetMapping("/calcAmt")
	public String servicef(Model m, @RequestParam("km") int km, @RequestParam("vid") String vid) {
		m.addAttribute("km", km);
		m.addAttribute("amt", km * 20);
		m.addAttribute("veh", vehicleService.getVehicleById(Integer.parseInt(vid)));
		return "user/servicef";
	}

	@GetMapping("/viewVehicle")
	public String viewVehicle(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);

		m.addAttribute("vlist", vehicleService.getAllVehicleByLocation(user.getLocation()));

		return "user/view_vehicle";
	}

	@GetMapping("/viewOneVehicle/{id}")
	public String viewOneVehicle(Model m, @PathVariable int id) {

		m.addAttribute("v", vehicleService.getVehicleById(id));

		return "user/view_one_vehicle";
	}

	@PostMapping("/boookVehic")
	public String bookingVech(@ModelAttribute BookVehicle bv, HttpSession session, @RequestParam("id") int id) {

		logger.debug("*** bookingVechicle() Exceution Started ***");

		if (userService.bookingVehicle(bv) != null) {

			logger.debug("*** bookingVehicle() Vehicle booking success ***");

			Vehicle vh = vehicleService.getVehicleById(id);
			vh.setAvailability("Booked");
			vehicleService.createVehicle(vh);

		} else {
			logger.debug("*** bookingVehicle() Something wrong on server ***");
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/user/bookSuccess";
	}

	@GetMapping("/bookSuccess")
	public String bookSuccess(Model m) {

		return "user/book_success";
	}

	@PostMapping("/createFeedback")
	public String createFeedback(@ModelAttribute Feedback fe, HttpSession session) {

		logger.debug("*** createFeedback() Exceution Started ***");

		if (userService.createFeedback(fe) != null) {
			logger.debug("*** createFeedback() Feedback saved success ***");
			session.setAttribute("succMsg", "Feedback Added sucesfully");

		} else {
			logger.debug("*** createFeedback() Something wrong on server ***");
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/user/contact";
	}

}
