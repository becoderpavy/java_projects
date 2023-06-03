package com.prog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class demo {

	
	  public static void main(String[] args) {
	  
	  String encode = new BCryptPasswordEncoder().encode("admin");
	  System.out.println(encode); }
	 

}
