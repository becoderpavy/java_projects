package com.rental.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private UserDtls buyer;

	@ManyToOne
	private UserDtls seller;

	@ManyToOne(fetch = FetchType.EAGER)
	private Home home;

	private String fromDate;

	private String toDate;

	private Double totalAmount;

	private Integer noOfDays;

	private String Status;

	private String bookingDate;

	private String bookingId;

	private String paymentType;

}
