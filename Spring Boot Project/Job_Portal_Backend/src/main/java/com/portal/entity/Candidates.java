package com.portal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Candidates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String fullName;

	private String email;

	private String mobNo;

	@ManyToOne
	private UserDtls user;

	@ManyToOne
	private UserDtls recruiter;

	@ManyToOne
	private Jobs job;

	private String resume;

	private String experience;

	private String technicalSkill;

	private String interviewDate;

	@Transient
	private int jobId;
	
	@Transient
	private int userId;

	@Transient
	private int recruiterId;

}
