package com.entity;

public class City {

	private int id;
	private int countryId;
	private int stateId;
	private String name;

	public City(int id, int countryId, int stateId, String name) {
		super();
		this.id = id;
		this.countryId = countryId;
		this.stateId = stateId;
		this.name = name;
	}

	public City() {
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

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
