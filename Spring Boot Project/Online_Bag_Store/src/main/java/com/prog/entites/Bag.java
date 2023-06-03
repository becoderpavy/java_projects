package com.prog.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String color;

	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Category category;

	@Column(name = "category_id", nullable = false)
	private int categortId;

	private String colthType;

	private Integer price;

	private String imgName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCategortId() {
		return categortId;
	}

	public void setCategortId(int categortId) {
		this.categortId = categortId;
	}

	public String getColthType() {
		return colthType;
	}

	public void setColthType(String colthType) {
		this.colthType = colthType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	

}
