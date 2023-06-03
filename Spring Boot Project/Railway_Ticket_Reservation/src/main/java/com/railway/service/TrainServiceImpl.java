package com.railway.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entites.TicketDtls;
import com.railway.entites.TrainDtls;
import com.railway.entites.TrainSchedule;
import com.railway.entites.UserDtls;
import com.railway.exception.ResourceNotFoundException;
import com.railway.jwt.JwtProvider;
import com.railway.repository.TicketRepo;
import com.railway.repository.TrainRepository;
import com.railway.repository.TrainScheduleRepo;
import com.railway.repository.UserRepository;

import io.jsonwebtoken.Claims;
import jdk.jshell.spi.ExecutionControl.UserException;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepo;

	@Autowired
	private TrainScheduleRepo trainSchRepo;

	@Autowired
	private TicketRepo ticketRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JwtProvider jwtProvider;

	public UserDtls getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User JWT", "Token", userId));

		return user;
	}

	@Override
	public TrainDtls saveTrain(TrainDtls train) {
		return trainRepo.save(train);
	}

	@Override
	public boolean existsTrainNumber(String trainno) {
		return trainRepo.existsByTrainNumber(trainno);
	}

	@Override
	public List<TrainDtls> getAllTrain() {
		return trainRepo.findAll();
	}

	@Override
	public TrainDtls getTrainById(int id) {
		return trainRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train", "Id", id));
	}

	@Override
	public boolean deleteTrain(int id) {
		TrainDtls train = trainRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train", "Id", id));

		if (train != null) {
			trainRepo.delete(train);
			return true;
		}

		return false;
	}

	@Override
	public TrainDtls updateTrain(TrainDtls t, int id) {
		TrainDtls train = trainRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train", "Id", id));

		train = train.builder().id(id).trainName(t.getTrainName()).trainNumber(t.getTrainNumber()).source(t.getSource())
				.destination(t.getDestination()).distance(t.getDistance()).price(t.getPrice())
				.seatCount(t.getSeatCount()).build();

		return trainRepo.save(train);
	}

	@Override
	public TrainSchedule saveTrainSchedule(TrainSchedule schedule) {
		TrainDtls train = trainRepo.findById(schedule.getTrainId())
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Id", schedule.getTrainId()));
		schedule.setTrain(train);
		return trainSchRepo.save(schedule);
	}

	@Override
	public List<TrainSchedule> getAllTrainSchedule() {
		return trainSchRepo.findAll();
	}

	@Override
	public List<TrainSchedule> getTrainScheduleByTrain(int trainId) {
		TrainDtls train = trainRepo.findById(trainId)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Id", trainId));

		return trainSchRepo.findByTrain(train);
	}

	@Override
	public TrainSchedule getScheduleById(int id) {
		return trainSchRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("TrainSchedule", "Id", id));
	}

	@Override
	public boolean deleteTrainSchedule(int id) {
		TrainSchedule ts = trainSchRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TrainSchedule", "Id", id));

		if (ts != null) {
			trainSchRepo.delete(ts);
			return true;
		}

		return false;
	}

	@Override
	public TrainSchedule updateTrainSchedule(TrainSchedule t, int id) {
		TrainSchedule ts = trainSchRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("TrainSchedule", "Id", id));

		ts = TrainSchedule.builder().id(id).train(ts.getTrain()).runOnDay(t.getRunOnDay())
				.departureTime(t.getDepartureTime()).arrivalTime(t.getArrivalTime()).build();

		return trainSchRepo.save(ts);
	}

	@Override
	public String saveTicket(TicketDtls ticket, HttpServletRequest request) {

		UserDtls user = getUserFromJwt(request);

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatDt = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm");

		TrainDtls train = trainRepo.findById(ticket.getTrainId())
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Id", ticket.getId()));

		TrainSchedule schedule = trainSchRepo.findById(ticket.getScheduleId())
				.orElseThrow(() -> new ResourceNotFoundException("Train Schedule", "Id", ticket.getId()));

		if (train.getId() == schedule.getTrain().getId()) {
			ticket.setTrain(train);
			ticket.setTrainSchedule(schedule);
			ticket.setBookingDate(date.format(formatDt));
			ticket.setUser(user);
			ticket.setPaymentStatus("success");
			ticket.setTicketStatus("Booked");
			ticketRepo.save(ticket);
			return "Ticket Booked Sucessfully";
		} else {
			return "Train Not Available wit this Schedule";
		}
	}

	@Override
	public List<TicketDtls> getTicketByUser(HttpServletRequest request) {

		UserDtls user = getUserFromJwt(request);

		return ticketRepo.findByUserOrderByIdDesc(user);
	}

	@Override
	public List<TrainDtls> searchTrain(String sr, String de) {
		return trainRepo.findBySourceAndDestination(sr, de);
	}

	@Override
	public List<TicketDtls> getAllTicket() {
		return ticketRepo.findAllByOrderByIdDesc();
	}

	@Override
	public void cancelTicket(int id) {

		TicketDtls ticket = ticketRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ticket", "id", id));
		ticket.setPaymentStatus("Refund Success");
		ticket.setTicketStatus("cancelled");
		ticketRepo.save(ticket);

	}

}
