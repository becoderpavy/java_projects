package com.railway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {

	private int id;

	private String journeyDate;

	private String bookingDate;

	private String travellerName;

	private String age;

	private String gender;

	private String email;

	private String mobNo;

	private int trainId;

	private int scheduleId;

}
