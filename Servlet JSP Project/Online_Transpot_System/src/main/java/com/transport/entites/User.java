package com.transport.entites;

public class User {

	private int id;

	private String fullName;

	private String userName;

	private String email;

	private String password;

	private String location;

	private String role;

	public User(String fullName, String userName, String email, String password, String location, String role) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.location = location;
		this.role = role;
	}

	public User(int id, String fullName, String userName, String email, String password, String location, String role) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.location = location;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", location=" + location + ", role=" + role + "]";
	}

}
