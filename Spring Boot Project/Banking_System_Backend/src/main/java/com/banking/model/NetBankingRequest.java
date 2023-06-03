package com.banking.model;

import lombok.Data;

@Data
public class NetBankingRequest {

	private String accno;
	private String username;
	private String password;
}
