package com.transport.service;

import java.util.List;

import com.transport.entites.Vehicle;

public interface VehicleService {

	public Vehicle createVehicle(Vehicle veh);

	public List<Vehicle> getAllVehicleByLocation(String location);

	public Vehicle getVehicleById(int id);

	public boolean deleteVehicle(int id);

	public Vehicle updateVehicle(Vehicle v);

	public List<Vehicle> getAllVehicleByAvailablity(String st);

	public List<Vehicle> getAllVehicle();
}
