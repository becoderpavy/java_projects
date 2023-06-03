package com.banking.model;

import lombok.Data;

@Data
public class SendMoneyRequest {

	private String senderAccountNo;
	
	private String name;
	
	private Double amount;
	
	
}
