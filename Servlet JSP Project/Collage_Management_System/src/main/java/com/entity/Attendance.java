package com.entity;

public class Attendance {
	private int id;
	private int stuId;
	private String name;
	private String course;
	private String semestar;
	private String year;
	private String month;
	private String days;

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(int id, int stuId, String name, String course, String semestar, String year, String month,
			String days) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.name = name;
		this.course = course;
		this.semestar = semestar;
		this.year = year;
		this.month = month;
		this.days = days;
	}

	public Attendance(int stuId, String name, String course, String semestar, String year, String month, String days) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.course = course;
		this.semestar = semestar;
		this.year = year;
		this.month = month;
		this.days = days;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", stuId=" + stuId + ", name=" + name + ", course=" + course + ", semestar="
				+ semestar + ", year=" + year + ", month=" + month + ", days=" + days + "]";
	}

}
