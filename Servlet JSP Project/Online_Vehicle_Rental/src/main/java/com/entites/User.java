package com.entites;

public class User {

	private int id;

	private String name;

	private String email;

	private String password;

	private String address;

	private String city;

	private String state;

	private String pincode;

	private String role;

	private String mobno;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String address, String city, String state, String pincode,
			String role, String mobno) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role = role;
		this.mobno = mobno;
	}

	public User(int id, String name, String email, String password, String address, String city, String state,
			String pincode, String role, String mobno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role = role;
		this.mobno = mobno;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
