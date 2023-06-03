package com.railway.controller;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railway.entites.TicketDtls;
import com.railway.entites.TrainDtls;
import com.railway.entites.TrainSchedule;
import com.railway.service.TrainService;

@RestController
@RequestMapping("/api/train")
public class TrainController {

	@Autowired
	private TrainService trainService;

	@PostMapping("/saveTrain")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> saveTrain(@RequestBody TrainDtls train) {

		if (trainService.existsTrainNumber(train.getTrainNumber())) {
			return new ResponseEntity<>("Train Number Already Exist", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(trainService.saveTrain(train), HttpStatus.CREATED);
		}

	}

	@GetMapping("/getAllTrain")
	public ResponseEntity<?> getAllTrain() {
		return new ResponseEntity<>(trainService.getAllTrain(), HttpStatus.OK);
	}

	@GetMapping("/getTrainById/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> getTrainById(@PathVariable int id) {
		return new ResponseEntity<>(trainService.getTrainById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteTrain/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> deleteTrain(@PathVariable int id) {
		return new ResponseEntity<>(trainService.deleteTrain(id), HttpStatus.OK);
	}

	@PutMapping("/updateTrain/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> updateTrain(@RequestBody TrainDtls train, @PathVariable int id) {
		return new ResponseEntity<>(trainService.updateTrain(train, id), HttpStatus.OK);
	}

	@PostMapping("/saveTrainSchedule")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> saveTrainSchedule(@RequestBody TrainSchedule schedule) {
		return new ResponseEntity<>(trainService.saveTrainSchedule(schedule), HttpStatus.CREATED);
	}

	@GetMapping("/getAllTrainSchedule")
	@RolesAllowed("ROLE_ADMIN")
	public ResponseEntity<?> getAllTrainSchedule() {
		return new ResponseEntity<>(trainService.getAllTrainSchedule(), HttpStatus.OK);
	}

	@GetMapping("/getTrainScheduleByTrainNo/{id}")
	public ResponseEntity<?> getTrainScheduleByTrain(@PathVariable int id) {
		return new ResponseEntity<>(trainService.getTrainScheduleByTrain(id), HttpStatus.OK);
	}

	@GetMapping("/getScheduleById/{id}")
//	@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
	public ResponseEntity<?> getScheduleById(@PathVariable int id) {
		return new ResponseEntity<>(trainService.getScheduleById(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteTrainSchedule/{id}")
	public ResponseEntity<?> deleteTrainSchedule(@PathVariable int id) {
		return new ResponseEntity<>(trainService.deleteTrainSchedule(id), HttpStatus.OK);
	}

	@PutMapping("/updateTrainSchedule/{id}")
	public ResponseEntity<?> updateTrainSchedule(@RequestBody TrainSchedule train, @PathVariable int id) {
//		System.out.println(train);
		return new ResponseEntity<>(trainService.updateTrainSchedule(train, id), HttpStatus.OK);
	}

	@PostMapping("/saveTicket")
	public ResponseEntity<?> saveTicket(@RequestBody TicketDtls ticket, HttpServletRequest request) {
		return new ResponseEntity<>(trainService.saveTicket(ticket, request), HttpStatus.CREATED);
	}

	@GetMapping("/getTicketByUser")
	public ResponseEntity<?> getTicketByUser(HttpServletRequest request) {
		return new ResponseEntity<>(trainService.getTicketByUser(request), HttpStatus.OK);
	}

	@GetMapping("/getAllTicket")
	public ResponseEntity<?> getAllTicket() {
		return new ResponseEntity<>(trainService.getAllTicket(), HttpStatus.OK);
	}

	@GetMapping("/searchTrain")
	public ResponseEntity<?> searchTrain(@RequestParam("sr") String sr, @RequestParam("de") String de) {
		return new ResponseEntity<>(trainService.searchTrain(sr, de), HttpStatus.OK);
	}

	@GetMapping("/cancelTicket/{id}")
	public ResponseEntity<?> cancelTicket(@PathVariable int id) {
		trainService.cancelTicket(id);
		return new ResponseEntity<>("Ticket Cancelled", HttpStatus.OK);
	}

}
