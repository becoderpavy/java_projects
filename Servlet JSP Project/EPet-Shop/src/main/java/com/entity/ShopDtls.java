package com.entity;

public class ShopDtls {
	
	private int id;
	private String ownerName;
	private String shopName;
	private String phno;
	private String address;
	private String city;
	private String state;
	private String email;
	private String password;
	private String image;
	private String role;
	private String status;

	public ShopDtls(String ownerName, String shopName, String phno, String address, String city, String state,
			String email, String password, String image, String role, String status) {
		super();
		this.ownerName = ownerName;
		this.shopName = shopName;
		this.phno = phno;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.password = password;
		this.image = image;
		this.role = role;
		this.status = status;
	}

	
	
	public ShopDtls(int id, String ownerName, String shopName, String phno, String address, String city, String state,
			String email, String password) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.shopName = shopName;
		this.phno = phno;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.password = password;
	}



	public ShopDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
