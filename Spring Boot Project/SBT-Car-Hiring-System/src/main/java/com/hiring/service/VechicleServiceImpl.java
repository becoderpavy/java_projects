package com.hiring.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiring.entites.OrderBooking;
import com.hiring.entites.Vechicle;
import com.hiring.repository.VechicleRepository;

@Service
public class VechicleServiceImpl implements VechicleService {

	@Autowired
	private VechicleRepository vechicleRepository;

	@Override
	public List<Vechicle> getAllVechicle() {
		return vechicleRepository.findAll();
	}

	@Override
	public List<Vechicle> getAllVechicleByType(String v) {

		return vechicleRepository.findByVehicleType(v);
	}

	@Override
	public Vechicle getVehicleById(long id) {

		return vechicleRepository.findById(id).get();
	}

	@Override
	public Double calculateAmount(OrderBooking o) {

		Period p = Period.between(LocalDate.parse(o.getBookingDate()), LocalDate.parse(o.getEndDate()));
		int days = p.getDays();
		Double day = (double) days;
		Vechicle v = vechicleRepository.findById(o.getVehicleId()).get();
		Double totalAmount = 0.0;
		if (o.getTo().equals("Srisailam")) {

			totalAmount = day * (v.getRentDay()) + 240 * (v.getAmountKm()) ;

		} else if (o.getTo().equals("Nagarjunasagar")) {
			totalAmount = day * (v.getRentDay()) + 180 * (v.getAmountKm()) ;
		} else {
			totalAmount = day * (v.getRentDay()) + 720 * (v.getAmountKm()) ;
		}

		return totalAmount;
	}

}
