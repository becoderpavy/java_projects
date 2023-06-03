package com.portal.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_dtls")
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long recruiterId;

	private String title;

	private String companyName;

	private String location;

	private String category;

	private String status;

	@Column(length = 1000)
	private String description;

	private String date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", recruiterId=" + recruiterId + ", title=" + title + ", companyName=" + companyName
				+ ", location=" + location + ", category=" + category + ", status=" + status + ", description="
				+ description + ", date=" + date + "]";
	}

}
