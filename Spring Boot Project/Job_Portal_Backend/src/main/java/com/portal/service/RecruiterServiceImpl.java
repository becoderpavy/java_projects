package com.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.entity.Candidates;
import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;
import com.portal.exception.ResourceNotFoundException;
import com.portal.jwt.JwtProvider;
import com.portal.repository.CandidateRepository;
import com.portal.repository.JobRepository;
import com.portal.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private JobRepository jobRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private CandidateRepository candidateRepo;

	public UserDtls getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);

		int userId = claim.get("userId", Integer.class);
		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "token is invalid with", userId));
		return user;
	}

	@Override
	public Jobs saveJobs(Jobs job, HttpServletRequest request) {

//		UserDtls user = userRepo.findById(job.getRecuiterId())
//				.orElseThrow(() -> new ResourceNotFoundException("user", "recuiter id", job.getRecuiterId()));

		UserDtls user = getUserFromJwt(request);

		job.setRecruiter(user);
		return jobRepo.save(job);
	}

	@Override
	public List<Jobs> getAllJobs(HttpServletRequest request) {
		UserDtls user = getUserFromJwt(request);
		return jobRepo.findByRecruiter(user);
	}

	@Override
	public Jobs getJobById(int id) {
		return jobRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("job", "id", id));
	}

	@Override
	public boolean deleteJobs(int id) {
		Jobs j = jobRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("job", "id", id));

		if (j != null) {
			jobRepo.delete(j);
			return true;
		}
		return false;
	}

	@Override
	public Jobs updateJobs(int id, Jobs j) {
		Jobs job = jobRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("job", "id", id));

		job = Jobs.builder().title(j.getTitle()).description(j.getDescription()).category(j.getCategory())
				.location(j.getLocation()).publishDate(j.getPublishDate()).lastApplyDate(j.getLastApplyDate())
				.companyName(j.getCompanyName()).vacancy(j.getVacancy()).recruiter(job.getRecruiter()).id(job.getId())
				.build();

		return jobRepo.save(job);
	}

	@Override
	public List<Candidates> getAllCandidates(HttpServletRequest request) {

		UserDtls user = getUserFromJwt(request);

		return candidateRepo.findByRecruiter(user);
	}

	@Override
	public List<Candidates> getCandidatesByJobId(HttpServletRequest request, int jobId) {

		UserDtls recruiter = getUserFromJwt(request);

		Jobs job = jobRepo.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("job", "id", jobId));

		return candidateRepo.findByRecruiterAndJob(recruiter, job);
	}

	@Override
	public Candidates getCandidatesById(int id) {
		Candidates can = candidateRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidates", "id", id));
		return can;
	}

	@Override
	public Candidates updateCanStatus(int id, String date) {
		Candidates can = candidateRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("candidates", "id", id));

		can.setInterviewDate(date);
		return candidateRepo.save(can);
	}

	@Override
	public UserDtls updateProfile(UserDtls user) {
		return userRepo.save(user);
	}

	@Override
	public List<Jobs> getAllJob() {
		return jobRepo.findAll();
	}
	
	

}
