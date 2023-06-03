package com.entites;

public class Vehicle {

	private int id;

	private String title;

	private String vehicleNumber;

	private int categoryId;

	private String availability;

	private Double perDay;

	private String insuranceStatus;

	private String description;

	private String ownerName;

	private String contactNo;

	private String image;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String title, String vehicleNumber, int categoryId, String availability, Double perDay,
			String insuranceStatus, String description, String ownerName, String contactNo, String image) {
		super();
		this.title = title;
		this.vehicleNumber = vehicleNumber;
		this.categoryId = categoryId;
		this.availability = availability;
		this.perDay = perDay;
		this.insuranceStatus = insuranceStatus;
		this.description = description;
		this.ownerName = ownerName;
		this.contactNo = contactNo;
		this.image = image;
	}

	public Vehicle(int id, String title, String vehicleNumber, int categoryId, String availability, Double perDay,
			String insuranceStatus, String description, String ownerName, String contactNo, String image) {
		super();
		this.id = id;
		this.title = title;
		this.vehicleNumber = vehicleNumber;
		this.categoryId = categoryId;
		this.availability = availability;
		this.perDay = perDay;
		this.insuranceStatus = insuranceStatus;
		this.description = description;
		this.ownerName = ownerName;
		this.contactNo = contactNo;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Double getPerDay() {
		return perDay;
	}

	public void setPerDay(Double perDay) {
		this.perDay = perDay;
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
