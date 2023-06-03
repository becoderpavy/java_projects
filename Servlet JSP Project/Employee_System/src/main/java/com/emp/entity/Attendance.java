package com.emp.entity;

public class Attendance {

	private int id;
	private String accountName;
	private String date;
	private String hours;
	private String milestone;
	private String remark;
	private String narration;
	private int userid;
	private String status;

	public Attendance(String accountName, String date, String hours, String milestone, String remark, String narration,
			int userid, String status) {
		super();
		this.accountName = accountName;
		this.date = date;
		this.hours = hours;
		this.milestone = milestone;
		this.remark = remark;
		this.narration = narration;
		this.userid = userid;
		this.status = status;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
