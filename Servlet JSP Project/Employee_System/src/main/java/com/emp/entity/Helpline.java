package com.emp.entity;

public class Helpline {

	private int id;
	private String title;
	private String reason;
	private int userid;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Helpline(String title, String reason, int userid, String status) {
		super();
		this.title = title;
		this.reason = reason;
		this.userid = userid;
		this.status = status;
	}

	public Helpline() {
		super();
		// TODO Auto-generated constructor stub
	}

}
