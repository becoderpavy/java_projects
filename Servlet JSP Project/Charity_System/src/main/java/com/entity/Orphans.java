package com.entity;

public class Orphans {
	private int id;
	private int orphangeid;
	private String name;
	private String problem;
	private String address;
	private String image;
	private String document;
	private Double needMoney;
	private Double raiseMoney;
	private String status;
	private String category;

	public Orphans(int orphangeid, String name, String problem, String address, String image, String document,
			Double needMoney, Double raiseMoney, String status, String category) {
		super();
		this.orphangeid = orphangeid;
		this.name = name;
		this.problem = problem;
		this.address = address;
		this.image = image;
		this.document = document;
		this.needMoney = needMoney;
		this.raiseMoney = raiseMoney;
		this.status = status;
		this.category = category;
	}

	public Orphans() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getOrphangeId() {
		return orphangeid;
	}

	public void setOrphangeId(int orphangeid) {
		this.orphangeid = orphangeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Double getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(Double needMoney) {
		this.needMoney = needMoney;
	}

	public Double getRaiseMoney() {
		return raiseMoney;
	}

	public void setRaiseMoney(Double raiseMoney) {
		this.raiseMoney = raiseMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
