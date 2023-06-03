package com.emp.entity;

public class Expenses {
	private int id;
	private String accountName;
	private String expenseType;
	private String description;
	private String milestone;
	private String expenseDate;
	private Double amount;
	private String documentName;
	private int userid;
	private String status;

	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expenses(String accountName, String expenseType, String description, String milestone, String expenseDate,
			Double amount, String documentName, int userid, String status) {
		super();
		this.accountName = accountName;
		this.expenseType = expenseType;
		this.description = description;
		this.milestone = milestone;
		this.expenseDate = expenseDate;
		this.amount = amount;
		this.documentName = documentName;
		this.userid = userid;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expenses [id=" + id + ", accountName=" + accountName + ", expenseType=" + expenseType + ", description="
				+ description + ", milestone=" + milestone + ", expenseDate=" + expenseDate + ", amount=" + amount
				+ ", documentName=" + documentName + ", userid=" + userid + ", status=" + status + "]";
	}

}
