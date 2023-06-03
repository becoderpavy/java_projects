package com.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobNo;

	private String dob;

	private String adharNum;

	private String address;

	private String city;

	private String state;

	private String pincode;

	private String role;

	private String password;

	private String accStatus;

	private String accountNum;
 
	@OneToOne
	private AccountBalance accBal;

	private String username;

	@Transient
	private String token;

}
