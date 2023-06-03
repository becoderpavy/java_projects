package com.entites;

public class Category {

	private int id;

	private String categoryName;

	private String image;

	public Category(String categoryName, String image) {
		super();
		this.categoryName = categoryName;
		this.image = image;
	}

	public Category(int id, String categoryName, String image) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.image = image;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
