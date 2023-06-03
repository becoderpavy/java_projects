package com.entites;

public class Scheme {
	private int id;
	private String schemeName;
	private String description;
	private String siteLink;
	private String publishDate;
	private String fileName;
	private String category;

	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheme(String schemeName, String description, String siteLink, String publishDate, String fileName,
			String category) {
		super();
		this.schemeName = schemeName;
		this.description = description;
		this.siteLink = siteLink;
		this.publishDate = publishDate;
		this.fileName = fileName;
		this.category = category;
	}

	public Scheme(int id, String schemeName, String description, String siteLink, String publishDate, String fileName,
			String category) {
		super();
		this.id = id;
		this.schemeName = schemeName;
		this.description = description;
		this.siteLink = siteLink;
		this.publishDate = publishDate;
		this.fileName = fileName;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiteLink() {
		return siteLink;
	}

	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
