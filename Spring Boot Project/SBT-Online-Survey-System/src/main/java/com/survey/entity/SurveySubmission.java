package com.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SurveySubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long userId;
	private int surveyId;
	private int ques1Ans;
	private int ques2Ans;
	private int ques3Ans;
	private int ques4Ans;
	private int ques5Ans;
	private int ques6Ans;
	private int ques7Ans;
	private int ques8Ans;
	private int ques9Ans;
	private int ques10Ans;

}
