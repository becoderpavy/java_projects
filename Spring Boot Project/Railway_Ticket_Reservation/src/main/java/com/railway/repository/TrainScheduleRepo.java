package com.railway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entites.TrainDtls;
import com.railway.entites.TrainSchedule;

public interface TrainScheduleRepo extends JpaRepository<TrainSchedule, Integer> {

	public List<TrainSchedule> findByTrain(TrainDtls train);
	
	
}
