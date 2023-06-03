package com.entity;

public class Category {
	private int id;
	private String categoryName;
	private String imageName;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String categoryName, String imageName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.imageName = imageName;
	}

	public Category(String categoryName, String imageName) {
		super();
		this.categoryName = categoryName;
		this.imageName = imageName;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
