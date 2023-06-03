package com.railway.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.railway.entites.TicketDtls;
import com.railway.entites.TrainDtls;
import com.railway.entites.TrainSchedule;
import com.railway.entites.UserDtls;
import com.railway.model.TicketRequest;

public interface TrainService {

	public TrainDtls saveTrain(TrainDtls train);

	public boolean existsTrainNumber(String trainno);

	public List<TrainDtls> getAllTrain();

	public TrainDtls getTrainById(int id);

	public boolean deleteTrain(int id);

	public TrainDtls updateTrain(TrainDtls train, int id);

	public TrainSchedule saveTrainSchedule(TrainSchedule schedule);

	public List<TrainSchedule> getAllTrainSchedule();

	public List<TrainSchedule> getTrainScheduleByTrain(int trainId);

	public TrainSchedule getScheduleById(int id);

	public boolean deleteTrainSchedule(int id);

	public TrainSchedule updateTrainSchedule(TrainSchedule t, int id);

	public String saveTicket(TicketDtls ticket, HttpServletRequest request);

	public List<TicketDtls> getTicketByUser(HttpServletRequest request);

	public List<TrainDtls> searchTrain(String sr, String de);

	public List<TicketDtls> getAllTicket();

	public void cancelTicket(int id);
}
