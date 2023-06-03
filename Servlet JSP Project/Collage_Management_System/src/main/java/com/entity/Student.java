package com.entity;

public class Student {
	private int id;
	private String roll;
	private String name;
	private String gender;
	private String dob;
	private String address;
	private String course;
	private String semestar;
	private String email;
	private String password;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String roll, String name, String gender, String dob, String address, String course,
			String semestar, String email, String password) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.course = course;
		this.semestar = semestar;
		this.email = email;
		this.password = password;
	}

	public Student(String roll, String name, String gender, String dob, String address, String course, String semestar,
			String email, String password) {
		super();
		this.roll = roll;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.course = course;
		this.semestar = semestar;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", gender=" + gender + ", dob=" + dob
				+ ", address=" + address + ", course=" + course + ", semestar=" + semestar + ", email=" + email
				+ ", password=" + password + "]";
	}

}
