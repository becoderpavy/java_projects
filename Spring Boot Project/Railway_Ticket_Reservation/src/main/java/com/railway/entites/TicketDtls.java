package com.railway.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class TicketDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String journeyDate;

	private String bookingDate;

	private String travellerName;

	private String age;

	private String gender;

	private String email;

	private String mobNo;
	
	private String paymentStatus;
	
	private String ticketStatus;

	@ManyToOne
	private UserDtls user;

	@ManyToOne
	private TrainDtls train;

	@Transient
	private int trainId;

	@ManyToOne
	private TrainSchedule trainSchedule;

	@Transient
	private int scheduleId;

}
