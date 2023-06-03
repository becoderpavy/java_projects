package com.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.entites.Vehicle;
import com.transport.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehiRepo;

	@Override
	public Vehicle createVehicle(Vehicle veh) {

		return vehiRepo.save(veh);
	}

	@Override
	public List<Vehicle> getAllVehicleByLocation(String location) {

		return vehiRepo.findByLocation(location);
	}
	
	

	@Override
	public Vehicle getVehicleById(int id) {

		return vehiRepo.findById(id).get();
	}

	@Override
	public boolean deleteVehicle(int id) {
		Vehicle veh = vehiRepo.findById(id).get();
		if (veh != null) {
			vehiRepo.delete(veh);
			return true;
		}
		return false;
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {

		return vehiRepo.save(v);
	}

	@Override
	public List<Vehicle> getAllVehicleByAvailablity(String st) {

		return vehiRepo.findByAvailability(st);
	}

	@Override
	public List<Vehicle> getAllVehicle() {

		return vehiRepo.findAll();
	}

}
