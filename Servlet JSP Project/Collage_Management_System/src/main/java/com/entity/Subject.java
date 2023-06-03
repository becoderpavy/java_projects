package com.entity;

public class Subject {

	private int id;
	private String course;
	private String semestar;
	private String subject;

	public Subject(String course, String semestar, String subject) {
		super();
		this.course = course;
		this.semestar = semestar;
		this.subject = subject;
	}

	public Subject(int id, String course, String semestar, String subject) {
		super();
		this.id = id;
		this.course = course;
		this.semestar = semestar;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
