package com.entity;

public class Teacher {
	private int id;
	private String name;
	private String gender;
	private String dob;
	private String qualification;
	private String email;
	private String password;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String gender, String dob, String qualification, String email, String password) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.qualification = qualification;
		this.email = email;
		this.password = password;
	}

	public Teacher(int id, String name, String gender, String dob, String qualification, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.qualification = qualification;
		this.email = email;
		this.password = password;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", qualification="
				+ qualification + ", email=" + email + ", password=" + password + "]";
	}
}
