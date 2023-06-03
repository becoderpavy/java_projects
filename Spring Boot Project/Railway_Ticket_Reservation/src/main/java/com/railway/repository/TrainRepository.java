package com.railway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entites.TrainDtls;

public interface TrainRepository extends JpaRepository<TrainDtls, Integer> {

	public boolean existsByTrainNumber(String trainNumber);

	public List<TrainDtls> findBySourceAndDestination(String sr, String de);

}
