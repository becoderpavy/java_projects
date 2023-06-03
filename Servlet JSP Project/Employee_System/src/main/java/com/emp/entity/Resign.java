package com.emp.entity;

public class Resign {
	private int id;
	private String resignType;
	private String resignDate;
	private String lastWorkingDate;
	private String noticeSuferd;
	private String contactNo;
	private String remark;
	private int userId;
	private String status;

	public Resign(String resignType, String resignDate, String lastWorkingDate, String noticeSuferd, String contactNo,
			String remark, int userId, String status) {
		super();
		this.resignType = resignType;
		this.resignDate = resignDate;
		this.lastWorkingDate = lastWorkingDate;
		this.noticeSuferd = noticeSuferd;
		this.contactNo = contactNo;
		this.remark = remark;
		this.userId = userId;
		this.status = status;
	}

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResignType() {
		return resignType;
	}

	public void setResignType(String resignType) {
		this.resignType = resignType;
	}

	public String getLastWorkingDate() {
		return lastWorkingDate;
	}

	public void setLastWorkingDate(String lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}

	public String getNoticeSuferd() {
		return noticeSuferd;
	}

	public void setNoticeSuferd(String noticeSuferd) {
		this.noticeSuferd = noticeSuferd;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getRemark() {
		return remark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Resign() {
		super();
		// TODO Auto-generated constructor stub
	}

}
