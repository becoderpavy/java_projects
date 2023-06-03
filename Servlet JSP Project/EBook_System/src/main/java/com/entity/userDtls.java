package com.entity;

public class userDtls {
	
	private int id;
	private String name;
	private String email;
	private String phno;
	private String password;
	private String adress;
	private String landmark;
	private String city;
	private String state;
	private String zip;
		
	public userDtls() {
		super();
		// TODO Auto-generated constructor stub
	}


	public userDtls(String name, String email, String phno, String password, String adress, String landmark,
			String city, String state, String zip) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.adress = adress;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.zip = zip;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getPhno() {
		return phno;
	}


	public void setPhno(String phno) {
		this.phno = phno;
	}


	@Override
	public String toString() {
		return "userDtls [id=" + id + ", name=" + name + ", email=" + email + ", phno=" + phno + ", password="
				+ password + ", adress=" + adress + ", landmark=" + landmark + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}

	
}
