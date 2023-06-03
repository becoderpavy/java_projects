package com.entites;

public class Cart {
	private int id;
	private int uid;
	private int mid;
	private int quantity;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int uid, int pid) {
		super();
		this.uid = uid;
		this.mid = pid;
	}

	public Cart(int id, int pid, int uid, int quantity) {
		super();
		this.id = id;
		this.uid = uid;
		this.mid = pid;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

}
