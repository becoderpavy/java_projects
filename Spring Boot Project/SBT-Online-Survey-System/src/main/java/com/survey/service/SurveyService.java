package com.survey.service;

import java.util.List;

import com.survey.entity.Survey;

public interface SurveyService {
	
	Survey saveSurvey(Survey survey);
	
	List<Survey> getAllSurvey();
	
	long getSurveyNo();
	
	Survey getSurveyById(int id);
}
