package com.transport.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookVehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String kms;

	private String amount;

	private String date;

	private String vehicleNumber;

	private String userName;

	private String location;

	public BookVehicle(String kms, String amount, String date, String vehicleNumber, String userName, String location) {
		super();
		this.kms = kms;
		this.amount = amount;
		this.date = date;
		this.vehicleNumber = vehicleNumber;
		this.userName = userName;
		this.location = location;
	}

	public BookVehicle(int id, String kms, String amount, String date, String vehicleNumber, String userName,
			String location) {
		super();
		this.id = id;
		this.kms = kms;
		this.amount = amount;
		this.date = date;
		this.vehicleNumber = vehicleNumber;
		this.userName = userName;
		this.location = location;
	}

	public BookVehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKms() {
		return kms;
	}

	public void setKms(String kms) {
		this.kms = kms;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumberr(String bikeNumber) {
		this.vehicleNumber = bikeNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

}
