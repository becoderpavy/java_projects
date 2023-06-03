package com.entity;

public class Orphanage {
	private int id;
	private String orgName;
	private String address;
	private String email;
	private String phno;
	private String password;
	private String status;

	public Orphanage(String orgName, String address, String email, String phno, String password, String status) {
		super();
		this.orgName = orgName;
		this.address = address;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.status = status;
	}

	public Orphanage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
