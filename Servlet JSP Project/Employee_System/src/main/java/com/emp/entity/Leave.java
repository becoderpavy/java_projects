package com.emp.entity;

public class Leave {

	private int id;
	private String leaveType;
	private String date_from;
	private String date_to;
	private String days;
	private String contact_no;
	private String reason;
	private int userId;
	private String status;

	public Leave(String leaveType, String date_from, String date_to, String days, String contact_no, String reason,
			int userId, String status) {
		super();
		this.leaveType = leaveType;
		this.date_from = date_from;
		this.date_to = date_to;
		this.days = days;
		this.contact_no = contact_no;
		this.reason = reason;
		this.userId = userId;
		this.status = status;
	}

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

}
