package com.entity;

public class bookDtls {
	private int id;
	private String bookName;
	private String authorName;
	private int price;
	private String categories;
	private String bookStatus;
	private String bookImg;
	private String userEmail;
	

	public bookDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bookDtls(int id, String bookName, String authorName, int price, String categories, String bookStatus,
			String bookImg) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.categories = categories;
		this.bookStatus = bookStatus;
		this.bookImg = bookImg;

	}

	public bookDtls(String bookName, String authorName, int price, String categories, String bookStatus, String bookImg,
			String userEmail) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.categories = categories;
		this.bookStatus = bookStatus;
		this.bookImg = bookImg;
		this.userEmail = userEmail;
	}
	public int getId() {
		return id;
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "bookDtls [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price
				+ ", categories=" + categories + ", bookStatus=" + bookStatus + ", bookImg=" + bookImg + ", userEmail="
				+ userEmail + "]";
	}

}
