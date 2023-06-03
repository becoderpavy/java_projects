package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.survey.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
	
	public List<Survey> findByStatus(String st);
	
	
	public List<Survey> findByTitleContains(String keyword);
	
}
