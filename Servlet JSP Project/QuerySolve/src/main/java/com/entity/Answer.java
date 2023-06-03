package com.entity;

public class Answer {
	private int id;
	private int question_id;
	private String userName;
	private String answer;
	private String post_date;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int question_id, String answer, String post_date) {
		super();
		this.question_id = question_id;
		this.answer = answer;
		this.post_date = post_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
