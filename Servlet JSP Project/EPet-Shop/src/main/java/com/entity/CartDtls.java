package com.entity;

public class CartDtls {
	private int id;
	private int userId;
	private int shopId;
	private int petsId;
	private String petsName;
	private Double price;
	private Double totalPrice;
	private String categorie;

	public CartDtls(int userId, int shopId, int petsId, String petsName, Double price, Double totalPrice,
			String categorie) {
		super();
		this.userId = userId;
		this.shopId = shopId;
		this.petsId = petsId;
		this.petsName = petsName;
		this.price = price;
		this.totalPrice = totalPrice;
		this.categorie = categorie;
	}

	public CartDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getPetsId() {
		return petsId;
	}

	public void setPetsId(int petsId) {
		this.petsId = petsId;
	}

	public String getPetsName() {
		return petsName;
	}

	public void setPetsName(String petsName) {
		this.petsName = petsName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartDtls [id=" + id + ", userId=" + userId + ", shopId=" + shopId + ", petsId=" + petsId + ", petsName="
				+ petsName + ", price=" + price + ", totalPrice=" + totalPrice + ", categorie=" + categorie + "]";
	}

}
