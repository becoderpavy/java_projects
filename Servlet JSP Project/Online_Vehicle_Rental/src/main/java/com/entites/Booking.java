package com.entites;

public class Booking {

	private int id;

	private int userId;

	private int vehicleId;

	private String fromDate;

	private String toDate;

	private String day;

	private Double totalPrice;

	private String idCard;

	private String orderId;

	private String status;

	private String bookingDate;

	public Booking(int userId, int vehicleId, String fromDate, String toDate, String day, Double totalPrice,
			String idCard, String orderId, String status, String bookingDate) {
		super();
		this.userId = userId;
		this.vehicleId = vehicleId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.day = day;
		this.totalPrice = totalPrice;
		this.idCard = idCard;
		this.orderId = orderId;
		this.status = status;
		this.bookingDate = bookingDate;
	}

	public Booking(int id, int userId, int vehicleId, String fromDate, String toDate, String day, Double totalPrice,
			String idCard, String orderId, String status, String bookingDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.vehicleId = vehicleId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.day = day;
		this.totalPrice = totalPrice;
		this.idCard = idCard;
		this.orderId = orderId;
		this.status = status;
		this.bookingDate = bookingDate;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
