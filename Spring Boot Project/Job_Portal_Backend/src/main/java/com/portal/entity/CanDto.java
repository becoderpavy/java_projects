package com.portal.entity;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CanDto {

	private String fullName;

	private String email;

	private String mobNo;

//	private String resume;

	private String experience;

	private String technicalSkill;

	private String interviewDate;

	private int jobId;

	private int recruiterId;

	private String img;

}
