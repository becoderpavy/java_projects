package com.transport.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.transport.entites.User;
import com.transport.entites.Vehicle;
import com.transport.repository.UserRepo;
import com.transport.service.UserService;
import com.transport.service.VehicleService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

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
		return "manager/index";
	}

	@GetMapping("/addVehicle")
	public String addManager() {
		return "manager/add_vehicle";
	}

	@GetMapping("/availVehicle")
	public String editManager(Model m) {
		m.addAttribute("list", vehicleService.getAllVehicleByAvailablity("Available"));
		return "manager/avail_vehicle";
	}

	@GetMapping("/bookVehicle")
	public String bookVehicle(Model m) {
		m.addAttribute("list", vehicleService.getAllVehicleByAvailablity("Booked"));
		return "manager/book_vehicle";
	}

	@GetMapping("/booking")
	public String booking(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("list", userService.getBookingByLocation(user.getLocation()));
		return "manager/booking";
	}

	@GetMapping("/editVehicle/{id}")
	public String editVehicle(Model m, @PathVariable int id) {
		m.addAttribute("v", vehicleService.getVehicleById(id));
		return "manager/edit_vehicle";
	}

	@GetMapping("/viewVehicle")
	public String viewVehicle(Model m, Principal p) {

		String email = p.getName();
		User user = userRepo.findByEmail(email);

		m.addAttribute("list", vehicleService.getAllVehicleByLocation(user.getLocation()));
		return "manager/view_vehicle";
	}

	@PostMapping("/createVehicle")
	public String createVehicle(@ModelAttribute Vehicle veh, @RequestParam("imgx") MultipartFile file,
			HttpSession session) {

		logger.debug("*** createVehicle() Exceution Started ***");

		veh.setImg(file.getOriginalFilename());

		if (vehicleService.createVehicle(veh) != null) {
			logger.debug("*** createVehicle() Vehicle added success ***");

			try {
				File saveFile = new ClassPathResource("static/veh_img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				// System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				e.printStackTrace();
				logger.error("Exception occured=" + e);
			}

			session.setAttribute("succMsg", "Vehicle Added sucesfully");

		} else {
			logger.debug("*** createVehicle() Something wrong on server ***");
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/manager/addVehicle";
	}

	@PostMapping("/updateVehicle")
	public String updateVehicle(@ModelAttribute Vehicle veh, @RequestParam("imgx") MultipartFile file,
			HttpSession session) {

		logger.debug("*** updateVehicle() Exceution Started ***");

		if (!file.isEmpty()) {
			veh.setImg(file.getOriginalFilename());
		}

		if (vehicleService.createVehicle(veh) != null) {
			logger.debug("*** updateVehicle() Vehicle update success ***");
			if (!file.isEmpty()) {

				try {
					File saveFile = new ClassPathResource("static/veh_img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
					// System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (IOException e) {
					logger.error("Exception occured=" + e);
					e.printStackTrace();

				}
			}
			session.setAttribute("succMsg", "Vehicle update sucesfully");

		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/manager/viewVehicle";
	}

	@GetMapping("/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable int id, HttpSession session) {

		logger.debug("*** deleteVehicle() Exceution Started ***");

		if (vehicleService.deleteVehicle(id)) {
			logger.debug("*** deleteVehicle() Vehicle delete success ***");
			session.setAttribute("succMsg", "Vehicle delete sucesfully");
		} else {
			logger.debug("*** createVehicle() Something wrong on server ***");
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/manager/viewVehicle";
	}

}
