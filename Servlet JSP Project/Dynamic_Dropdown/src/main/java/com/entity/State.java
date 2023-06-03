package com.entity;

public class State {
	private int id;
	private int countryId;
	private String name;

	public State(int id, int countryId, String name) {
		super();
		this.id = id;
		this.countryId = countryId;
		this.name = name;
	}

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
