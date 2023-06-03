package com.entity;

public class Notice {

	private int id;
	private String name;
	private String message;
	private String date;

	public Notice(int id, String name, String message, String date) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.date = date;
	}

	public Notice(String name, String message, String date) {
		super();
		this.name = name;
		this.message = message;
		this.date = date;
	}

	public Notice() {
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
