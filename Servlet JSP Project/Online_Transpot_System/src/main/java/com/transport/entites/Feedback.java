package com.transport.entites;

public class Feedback {

	private int id;

	private String username;

	private String message;

	private String response;

	public Feedback(String username, String message, String response) {
		super();
		this.username = username;
		this.message = message;
		this.response = response;
	}

	public Feedback(int id, String username, String message, String response) {
		super();
		this.id = id;
		this.username = username;
		this.message = message;
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
