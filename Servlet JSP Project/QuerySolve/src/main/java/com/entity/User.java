package com.entity;

public class User {
	private int id;
	private String fullName;
	private String email;
	private String gender;
	private String collageId;
	private String category;
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String fullName, String email, String gender, String collageId, String category, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.collageId = collageId;
		this.category = category;
		this.password = password;
	}
	
	

	public User(int id, String fullName, String email, String gender, String collageId, String category) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.collageId = collageId;
		this.category = category;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollageId() {
		return collageId;
	}

	public void setCollageId(String collageId) {
		this.collageId = collageId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", gender=" + gender + ", collageId="
				+ collageId + ", category=" + category + ", password=" + password + "]";
	}

}
