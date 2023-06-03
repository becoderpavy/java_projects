package com.banking.model;

import lombok.Data;

@Data
public class ChangePasswordRequest {

	private String oldPassword;
	private String newPassword;
	
}
