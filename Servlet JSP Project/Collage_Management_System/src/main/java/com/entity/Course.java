package com.entity;

public class Course {
	private int id;
	private String course;

	public Course(int id, String course) {
		super();
		this.id = id;
		this.course = course;
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

}
