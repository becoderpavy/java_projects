package com.entity;

public class PetDtls {

	private int id;
	private int shopid;
	private String category;
	private String petName;
	private String description;
	private Double price;
	private int stock;
	private String image;
	private String status;

	
	
	public PetDtls(int id, int shopid, String category, String petName, String description, Double price, int stock,
			String image, String status) {
		super();
		this.id = id;
		this.shopid = shopid;
		this.category = category;
		this.petName = petName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.status = status;
	}

	public PetDtls(int shopid, String category, String petName, String description, Double price, int stock,
			String image, String status) {
		super();
		this.shopid = shopid;
		this.category = category;
		this.petName = petName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.status = status;
	}

	public PetDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
