package com.transport.entites;

public class Vehicle {

	private int id;

	private String vechicleNumber;

	private String vehicleType;

	private String location;

	private String availability;

	private String insuranceStatus;

	private String description;

	private String ownerName;

	private String contactNo;

	public Vehicle(String vechicleNumber, String vehicleType, String location, String availability,
			String insuranceStatus, String description, String ownerName, String contactNo) {
		super();
		this.vechicleNumber = vechicleNumber;
		this.vehicleType = vehicleType;
		this.location = location;
		this.availability = availability;
		this.insuranceStatus = insuranceStatus;
		this.description = description;
		this.ownerName = ownerName;
		this.contactNo = contactNo;
	}

	public Vehicle(int id, String vechicleNumber, String vehicleType, String location, String availability,
			String insuranceStatus, String description, String ownerName, String contactNo) {
		super();
		this.id = id;
		this.vechicleNumber = vechicleNumber;
		this.vehicleType = vehicleType;
		this.location = location;
		this.availability = availability;
		this.insuranceStatus = insuranceStatus;
		this.description = description;
		this.ownerName = ownerName;
		this.contactNo = contactNo;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVechicleNumber() {
		return vechicleNumber;
	}

	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
