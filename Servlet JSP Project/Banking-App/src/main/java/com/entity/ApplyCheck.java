package com.entity;

public class ApplyCheck {

	private int id;
	private String name;
	private String accountNo;
	private String status;
	public ApplyCheck(int id, String name, String accountNo, String status) {
		super();
		this.id = id;
		this.name = name;
		this.accountNo = accountNo;
		this.status = status;
	}
	
	
	public ApplyCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
