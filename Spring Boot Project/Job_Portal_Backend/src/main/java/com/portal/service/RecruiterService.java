package com.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.portal.entity.Candidates;
import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;

public interface RecruiterService {

	public Jobs saveJobs(Jobs job, HttpServletRequest request);

	public List<Jobs> getAllJobs(HttpServletRequest request);
	
	public List<Jobs> getAllJob();

	public Jobs getJobById(int id);

	public boolean deleteJobs(int id);

	public Jobs updateJobs(int id, Jobs job);

	public List<Candidates> getAllCandidates(HttpServletRequest request);

	public List<Candidates> getCandidatesByJobId(HttpServletRequest request, int jobId);

	public Candidates getCandidatesById(int id);

	public Candidates updateCanStatus(int id, String date);

	public UserDtls updateProfile(UserDtls user);
	
}
