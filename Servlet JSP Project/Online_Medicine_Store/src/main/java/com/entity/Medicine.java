package com.entity;

public class Medicine {
	private int id;
	private String name;
	private String description;
	private String price;
	private String category;
	private String imageName;
	private int art_id;

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(String name, String description, String price, String category, String imageName,int art_id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.imageName = imageName;
		this.art_id=art_id;
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

	public void setName(String title) {
		this.name = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public int getArt_id() {
		return art_id;
	}

	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}

	@Override
	public String toString() {
		return "Paintings [id=" + id + ", title=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", imageName=" + imageName + "]";
	}

}
