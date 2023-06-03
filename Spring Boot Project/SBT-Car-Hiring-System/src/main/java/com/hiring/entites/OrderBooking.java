package com.hiring.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class OrderBooking {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "vehicle_id")
	private long vehicleId;

	@Column(name = "vehicle_name")
	private String vehicleName;

	@Column(name = "order_id")
	private String orderId;

	 @Column(name = "from_place")
	private String from;

	 @Column(name = "to_place")
	private String to;

	@Column(name = "booking_date")
	private String bookingDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "total_amount")
	private Double totalAmount;

}
