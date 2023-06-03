package com.prog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private String category;
	private String regNum;
	private String dateFrom;
	private String dateTo;
	private String totalRent;
	private String paymentAdvnace;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(String customerName, String category, String regNum, String dateFrom, String dateTo,
			String totalRent, String paymentAdvnace) {
		super();
		this.customerName = customerName;
		this.category = category;
		this.regNum = regNum;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.totalRent = totalRent;
		this.paymentAdvnace = paymentAdvnace;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(String totalRent) {
		this.totalRent = totalRent;
	}

	public String getPaymentAdvnace() {
		return paymentAdvnace;
	}

	public void setPaymentAdvnace(String paymentAdvnace) {
		this.paymentAdvnace = paymentAdvnace;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerName=" + customerName + ", category=" + category + ", regNum=" + regNum
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", totalRent=" + totalRent + ", paymentAdvnace="
				+ paymentAdvnace + "]";
	}

}
