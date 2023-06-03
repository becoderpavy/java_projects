package com.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class SurveyQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;

	@Column(name = "first_ans")
	private String firstAns;
	
	@Column(name = "second_ans")
	private String secondAns;
	
	@Column(name = "third_ans")
	private String thirdAns;
	
	@Column(name = "fourth_ans")
	private String fourthAns;

	@Column(name = "survey_id")
	private int surveyId;

}
