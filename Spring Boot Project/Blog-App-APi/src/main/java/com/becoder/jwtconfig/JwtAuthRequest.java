package com.becoder.jwtconfig;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String email;
	
	private String password;
}
