package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.SurveySubmission;

public interface SurveySubmissionRepo extends JpaRepository<SurveySubmission, Integer>{

	public boolean existsByUserIdAndSurveyId(long uid,int sid);
	
	public List<SurveySubmission> findBySurveyId(int sid);
	
	public List<SurveySubmission> findByUserId(long uid);
	
	public SurveySubmission findBySurveyIdAndUserId(int sid,long uid);
	
	
}
