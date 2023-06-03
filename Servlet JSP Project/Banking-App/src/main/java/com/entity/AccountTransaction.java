package com.entity;

import java.time.*;

public class AccountTransaction {
	private int id;
	private String accno;
	private String transType;
	private String transDtls;
	private Double balance;
	private String transDate;
	private String transTime;

	public AccountTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getTransDtls() {
		return transDtls;
	}

	public void setTransDtls(String transDtls) {
		this.transDtls = transDtls;
	}

}
