package com.entites;

public class Movies {

	private int id;
	private String moviesName;
	private String language;
	private String category;
	private String ratings;
	private String quantity;
	private String cost;
	private String description;
	private int storeId;
	private String img;

	public Movies(int id, String moviesName, String language, String category, String ratings, String quantity,
			String cost, String description, int storeId, String img) {
		super();
		this.id = id;
		this.moviesName = moviesName;
		this.language = language;
		this.category = category;
		this.ratings = ratings;
		this.quantity = quantity;
		this.cost = cost;
		this.description = description;
		this.storeId = storeId;
		this.img = img;
	}

	public Movies(String moviesName, String language, String category, String ratings, String quantity, String cost,
			String description, int storeId, String img) {
		super();
		this.moviesName = moviesName;
		this.language = language;
		this.category = category;
		this.ratings = ratings;
		this.quantity = quantity;
		this.cost = cost;
		this.description = description;
		this.storeId = storeId;
		this.img = img;
	}

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoviesName() {
		return moviesName;
	}

	public void setMoviesName(String moviesName) {
		this.moviesName = moviesName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
