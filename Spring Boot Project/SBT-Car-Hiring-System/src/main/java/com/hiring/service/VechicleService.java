package com.hiring.service;

import java.util.List;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.Vechicle;

public interface VechicleService {

	public List<Vechicle> getAllVechicle();
	
	public List<Vechicle> getAllVechicleByType(String v);
	
	public Vechicle getVehicleById(long id);


	public Double calculateAmount(OrderBooking o);
	
	
}
