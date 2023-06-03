package com.entites;

public class Orders {
	private int id;
	private String orderId;
	private int movieId;
	private int userId;
	private int quantity;
	private String totalAmount;
	private String paymentType;
	private int storeId;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderId, int movieId, int userId, int quantity, String totalAmount, String paymentType,
			int storeId) {
		super();
		this.orderId = orderId;
		this.movieId = movieId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.storeId = storeId;
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

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderId=" + orderId + ", movieId=" + movieId + ", userId=" + userId
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", paymentType=" + paymentType
				+ ", storeId=" + storeId + "]";
	}
	
	

}
