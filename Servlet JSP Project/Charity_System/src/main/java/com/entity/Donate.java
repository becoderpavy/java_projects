package com.entity;

public class Donate {
	private int id;
	private int did;
	private int pid;
	private String name;
	private Double amount;
	private String status;

	public Donate(int did, int pid, String name, Double amount, String status) {
		super();
		this.did = did;
		this.pid = pid;
		this.name = name;
		this.amount = amount;
		this.status = status;
	}

	public Donate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
