package com.prog.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prog.entity.Booking;
import com.prog.entity.Vehicle;
import com.prog.repository.BookingRepository;
import com.prog.repository.VehicleRepository;

@Controller
public class HomeController {

	@Autowired
	private VehicleRepository vehRepo;

	@Autowired
	private BookingRepository bookRepo;

	@GetMapping("/")
	public String home(Model m) {
		return "index";
	}

	@GetMapping("/addVehicle")
	public String addVehicle() {
		return "add_vehicle";
	}

	@GetMapping("/book")
	public String booking() {
		return "book";
	}

	@PostMapping("/createVehicle")
	public String creteVehicle(@ModelAttribute Vehicle veh, HttpSession session) {
		veh.setStatus("Available");
		if (vehRepo.save(veh) != null) {
			session.setAttribute("msg", "Vehicle Added Sucesfully");
		} else {
			session.setAttribute("msg", "Something wrong on error");
		}
		return "redirect:/addVehicle";
	}

	@GetMapping("/getAllReg")
	@ResponseBody
	public List<Vehicle> getAllVehicleByCategory(@RequestParam String cat) {
		return vehRepo.findByCategory(cat);
	}

	@GetMapping("/getTotalRent")
	@ResponseBody
	public long getTotalRent(@RequestParam String reg, @RequestParam String dtFrm, @RequestParam String dtTo) {

		Period p = Period.between(LocalDate.parse(dtFrm), LocalDate.parse(dtTo));
		// System.out.println(p.getDays());

		long totalAmt = vehRepo.findByRegistrationNumber(reg).getDailyRent() * p.getDays();

		return totalAmt;
	}

	@PostMapping("/addBook")
	@ResponseBody
	public String addBook(@RequestParam String cn, @RequestParam String ca, @RequestParam String re,
			@RequestParam String df, @RequestParam String dt, @RequestParam String ta, @RequestParam String ad) {

		Booking bk = new Booking(cn, ca, re, df, dt, ta, ad);

		if (vehRepo.findByRegistrationNumber(re).getStatus().equals("Available")) {
			if (bookRepo.save(bk) != null) {

				Vehicle veh = vehRepo.findByRegistrationNumber(re);
				veh.setStatus("Booked");
				vehRepo.save(veh);

				return "Booking Sucess";
			} else {
				return "something wrong on server";
			}
		} else {
			return "Vehicle Not Available";
		}

	}

	@GetMapping("/report")
	public String report(Model m) {

		m.addAttribute("tcar", vehRepo.findByCategory("car").size());
		m.addAttribute("ttruck", vehRepo.findByCategory("truck").size());
		m.addAttribute("tbus", vehRepo.findByCategory("bus").size());

		m.addAttribute("tncar", bookRepo.findByCategory("car").size());
		m.addAttribute("tntruck", bookRepo.findByCategory("truck").size());
		m.addAttribute("tnbus", bookRepo.findByCategory("bus").size());

		long pcar = 0;
		long ptruck = 0;
		long pbus = 0;

		List<Booking> list = bookRepo.findAll();

		for (Booking b : list) {

			if ("Truck".equals(b.getCategory())) {

				ptruck = Long.parseLong(b.getTotalRent()) + ptruck;

			} else if ("Car".equals(b.getCategory())) {

				pcar = Long.parseLong(b.getTotalRent()) + pcar;

			} else if ("Bus".equals(b.getCategory())) {

				pbus = Long.parseLong(b.getTotalRent()) + pbus;
			}
		}

		m.addAttribute("pcar", pcar);
		m.addAttribute("ptruck", ptruck);
		m.addAttribute("pbus", pbus);

		return "report";
	}

}
