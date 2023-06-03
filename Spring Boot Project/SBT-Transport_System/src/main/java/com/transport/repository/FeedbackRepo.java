package com.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.entites.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

	public List<Feedback> findByUsername(String username);
}
