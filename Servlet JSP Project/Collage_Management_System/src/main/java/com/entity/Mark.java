package com.entity;

public class Mark {
	private int id;
	private int stuid;
	private String roll;
	private String name;
	private String course;
	private String semestar;
	private String subject;
	private int mark;

	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mark(int stuid, String roll, String name, String course, String semestar, String subject, int mark) {
		super();
		this.stuid = stuid;
		this.roll = roll;
		this.name = name;
		this.course = course;
		this.semestar = semestar;
		this.subject = subject;
		this.mark = mark;
	}

	public Mark(int id, int stuid, String roll, String name, String course, String semestar, String subject, int mark) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.roll = roll;
		this.name = name;
		this.course = course;
		this.semestar = semestar;
		this.subject = subject;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Mark [id=" + id + ", stuid=" + stuid + ", roll=" + roll + ", name=" + name + ", course=" + course
				+ ", semestar=" + semestar + ", subject=" + subject + ", mark=" + mark + "]";
	}

}
