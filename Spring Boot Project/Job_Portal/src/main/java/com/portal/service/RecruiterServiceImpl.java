package com.portal.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.entites.Jobs;
import com.portal.entites.User;
import com.portal.repository.JobRepository;
import com.portal.repository.UserRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private JobRepository jobRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Jobs addJob(Jobs job) {

		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		job.setDate(now.format(format) + "");
		return jobRepo.save(job);
	}

	@Override
	public Jobs getJobById(long id) {
		return jobRepo.findById(id).get();
	}

	@Override
	public List<Jobs> getJobsByRecruiterId(long id) {
		return jobRepo.findByRecruiterIdOrderByIdDesc(id);
	}

	@Override
	public boolean deleteJob(long id) {
		Jobs j = jobRepo.findById(id).get();
		if (j != null) {
			jobRepo.delete(j);
			return true;
		}
		return false;
	}

	@Override
	public User updateProfile(User user) {

		User oldUser = userRepo.findById(user.getId()).get();
		user.setPrimarySkill("NA");
		user.setExperience("NA");
		user.setRole("ROLE_RECRUITER");
		user.setPassword(oldUser.getPassword());

		return userRepo.save(user);
	}

}
