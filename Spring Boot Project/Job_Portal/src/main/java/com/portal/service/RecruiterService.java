package com.portal.service;

import java.util.List;

import com.portal.entites.Jobs;
import com.portal.entites.User;

public interface RecruiterService {

	public Jobs addJob(Jobs job);

	public Jobs getJobById(long id);

	public List<Jobs> getJobsByRecruiterId(long id);

	public boolean deleteJob(long id);

	public User updateProfile(User user);

	

}
