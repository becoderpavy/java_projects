package com.entity;

public class MedicineStore {
	private int id;
	private String fullName;
	private String shopName;
	private String email;
	private String mobNo;
	private String password;
	private String address;
	private String city;
	private String state;
	private String pincode;

	public MedicineStore() {
		super();
	}

	public MedicineStore(String fullName, String shopName, String email, String mobNo, String password, String address,
			String city, String state, String pincode) {
		super();
		this.fullName = fullName;
		this.shopName = shopName;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
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

	@Override
	public String toString() {
		return "Artist [id=" + id + ", fullName=" + fullName + ", shopName=" + shopName + ", email=" + email
				+ ", mobNo=" + mobNo + ", password=" + password + ", address=" + address + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}

}
