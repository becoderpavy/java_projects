package com.survey.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.entity.Survey;
import com.survey.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	private SurveyRepository surveyRepo;

	@Override
	public Survey saveSurvey(Survey survey) {
		return surveyRepo.save(survey);
	}

	@Override
	public List<Survey> getAllSurvey() {

		return surveyRepo.findAll();
	}

	@Override
	public long getSurveyNo() {

		return surveyRepo.count();
	}

	@Override
	public Survey getSurveyById(int id) {

		Optional<Survey> op = surveyRepo.findById(id);
		return op.get();
	}
}
