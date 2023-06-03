package com.entity;

public class UserDtls {

	private int id;
	private String name;
	private String email;
	private String phno;
	private String password;
	private String status;
	private String role;

	public UserDtls(String name, String email, String phno, String password, String status, String role) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public UserDtls() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDtls [id=" + id + ", name=" + name + ", email=" + email + ", phno=" + phno + ", password="
				+ password + ", status=" + status + ", role=" + role + "]";
	}

}
