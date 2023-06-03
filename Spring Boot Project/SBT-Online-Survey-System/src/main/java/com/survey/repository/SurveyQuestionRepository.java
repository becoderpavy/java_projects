package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.entity.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Integer> {

	public List<SurveyQuestion> findBySurveyId(int id);
	
	

}
