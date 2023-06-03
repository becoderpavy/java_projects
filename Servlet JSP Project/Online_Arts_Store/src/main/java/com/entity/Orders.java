package com.entity;

public class Orders {
	private int id;
	private String orderId;
	private int paintId;
	private int userId;
	private int quantity;
	private String totalAmount;
	private String paymentType;
	private int art_id;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderId, int paintId, int userId, int quantity, String totalAmount, String paymentType) {
		super();
		this.orderId = orderId;
		this.paintId = paintId;
		this.userId = userId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
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

	public int getPaintId() {
		return paintId;
	}

	public void setPaintId(int paintId) {
		this.paintId = paintId;
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

	public int getArt_id() {
		return art_id;
	}

	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderId=" + orderId + ", paintId=" + paintId + ", userId=" + userId
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", paymentType=" + paymentType + "]";
	}

}
