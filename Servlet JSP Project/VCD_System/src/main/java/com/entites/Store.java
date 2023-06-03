package com.entites;

public class Store {
	private int id;
	private String storeName;
	private String mobNo;
	private String address;
	private String storeImg;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(int id, String storeName, String mobNo, String address, String storeImg) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.mobNo = mobNo;
		this.address = address;
		this.storeImg = storeImg;
	}

	public Store(String storeName, String mobNo, String address, String storeImg) {
		super();
		this.storeName = storeName;
		this.mobNo = mobNo;
		this.address = address;
		this.storeImg = storeImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

}
