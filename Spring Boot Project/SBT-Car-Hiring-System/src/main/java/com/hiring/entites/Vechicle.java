package com.hiring.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vechicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "vehicle_name")
	private String vehicleName;
	
	private String fuel;
	
	@Column(name = "seat_capacity")
	private int seatCapacity;
	
	@Column(name = "rent_day")
	private Double rentDay;
	
	@Column(name = "amount_km")
	private Double amountKm;
	
	private String image;
	
	
	

}
