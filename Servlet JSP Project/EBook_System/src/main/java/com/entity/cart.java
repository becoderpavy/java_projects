package com.entity;

public class cart {
	private int cid;
	private int bid;
	private int uid;
	private String bookName;
	private String author;
	private int price;
	private int totalprice;

	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cart(int bid, int uid, String bookName, String author, int price) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "cart [cid=" + cid + ", bid=" + bid + ", uid=" + uid + ", bookName=" + bookName + ", price=" + price
				+ "]";
	}

}
