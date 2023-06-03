package com.entity;

public class Candidates {

	private int id;
	private String name;
	private String email;
	private int userId;
	private int jobId;
	private String interviewDate;
	private String resume;

	public Candidates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Candidates(String name, String email, int userId, int jobId, String interviewDate, String resume) {
		super();
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.jobId = jobId;
		this.interviewDate = interviewDate;
		this.resume = resume;
	}

	public Candidates(int id, String name, String email, int userId, int jobId, String interviewDate, String resume) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.jobId = jobId;
		this.interviewDate = interviewDate;
		this.resume = resume;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

}
