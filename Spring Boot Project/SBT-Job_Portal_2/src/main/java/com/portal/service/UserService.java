package com.portal.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.portal.entites.Candidates;
import com.portal.entites.Jobs;
import com.portal.entites.User;

public interface UserService {

	public boolean checkEmail(String email);

	public User createUser(User user);

	public User updateProfile(User user);

	public Page<Jobs> getAllJob(int pageNo, int pageSize);

	public Jobs getJobById(long id);

	public Candidates saveCandidates(Candidates c);

	public List<Candidates> getAppliedJobByUser(long uid);

	public Candidates getCandidateById(long id);

	public boolean checkJobApplied(long jobId, long userId);

	public List<Jobs> searchJob(String cn, String lo);

	public boolean checkEmailAndMob(String email, String mobNo);

	public User updatePassword(User user);

}
