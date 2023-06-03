package com.realstate.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	@Column(name = "owner_name")
	private String ownerName;

	private String email;

	private String mobNo;

	private String description;

	private String address;

	private String city;

	private String state;

	private String pincode;

	@Column(name = "file_name")
	private String fileName;

}
