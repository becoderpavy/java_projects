package com.entity;

public class OrderDtls {
	private int id;
	private int userId;
	private int shopId;
	private String orderId;
	private String userName;
	private String email;
	private String address;
	private String phno;
	private String categorie;
	private String petName;
	private Double price;
	private String paymentType;
	private String status;
	private String date;

	public OrderDtls(int userId, int shopId, String orderId, String userName, String email, String address, String phno,
			String categorie, String petName, Double price, String paymentType, String status, String date) {
		super();
		this.userId = userId;
		this.shopId = shopId;
		this.orderId = orderId;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phno = phno;
		this.categorie = categorie;
		this.petName = petName;
		this.price = price;
		this.paymentType = paymentType;
		this.status = status;
		this.date = date;
	}

	public OrderDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
