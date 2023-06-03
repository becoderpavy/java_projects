package com.library.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String bookName;

	private String author;

	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Category category;

	@Column(name = "category_id", nullable = false)
	private int categortId;

	private String isbnNo;

	private Integer price;

	private String imgName;

	private int stock;

	@ManyToOne
	private LibraryDtls library;

	public LibraryDtls getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDtls library) {
		this.library = library;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}

	public int getCategortId() {
		return categortId;
	}

	public void setCategortId(int categortId) {
		this.categortId = categortId;
	}

}
