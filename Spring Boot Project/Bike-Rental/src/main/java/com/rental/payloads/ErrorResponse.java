package com.rental.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	private String message;

	private String details;

	private Date timeStamp;

}
