package com.entity;

public class Book {
	private int id;
	private String bookName;
	private String author;
	private String department;
	private String imageName;
	private String pdfName;
	private String status;
	private String description;
	
	

	public Book(int id, String bookName, String author, String department, String imageName, String pdfName,
			String status, String description) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.department = department;
		this.imageName = imageName;
		this.pdfName = pdfName;
		this.status = status;
		this.description = description;
	}

	public Book(String bookName, String author, String department, String imageName, String pdfName, String status,
			String description) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.department = department;
		this.imageName = imageName;
		this.pdfName = pdfName;
		this.status = status;
		this.description = description;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", department=" + department
				+ ", imageName=" + imageName + ", pdfName=" + pdfName + ", status=" + status + ", description="
				+ description + "]";
	}

}
